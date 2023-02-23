package com.sof.Security.handler;

import com.sof.Security.Jwt.JwtTokenizer;
import com.sof.Users.Entity.UserEntity;
import com.sof.Users.Service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtTokenizer jwtTokenizer;
    private final UserService userService;

    public OAuth2SuccessHandler(JwtTokenizer jwtTokenizer, UserService userService) {
        this.jwtTokenizer = jwtTokenizer;
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        var oAuth2User = (OAuth2User) authentication.getPrincipal(); //var: 변수의 타입을 추론하여 설정해줌

        System.out.println(oAuth2User.getAttributes().get("response"));

        String sub = "";
        String email = "";
        String name = "";
        //String profileImage = "";

        if(oAuth2User.getAttributes().containsKey("response")) {
            String tmp = oAuth2User.getAttributes().get("response").toString().replaceAll("\\{", "").replaceAll("}", "").replaceAll(", ", "=");
            String[] tmpArr = tmp.split("=");

            for(int i = 0; i < tmpArr.length; i++) {
                if(tmpArr[i].equals("id")) { sub = tmpArr[i + 1]; }
                else if(tmpArr[i].equals("email")) { email = tmpArr[i + 1]; }
                else if(tmpArr[i].equals("name")) { name = tmpArr[i + 1]; }
                }
            }
        else {
            sub = String.valueOf(oAuth2User.getAttributes().get("sub"));
            email = String.valueOf(oAuth2User.getAttributes().get("email"));
            name = String.valueOf(oAuth2User.getAttributes().get("name"));
            //profileImage = String.valueOf(oAuth2User.getAttributes().get("picture"));
        }
        System.out.println(oAuth2User.getAttributes().toString());

        saveUser(sub, email, name);
        redirect(request, response, email);
    }

    private void saveUser(String sub, String email, String name) {
        UserEntity user = userService.findByEmailCreate(email);

        if(user == null) {
            user = new UserEntity();
            user.setEmail(email);
            user.setName(name);
            //user.setProfileImage(profileImage);
            user.setCreateDate(LocalDateTime.now());
            user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("테스트 프젝!"));
            userService.createUser(user);
        }
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String email) throws IOException {
        String accessToken = delegateAccessToken(email);
        UserEntity user = userService.findByEmail(email);

        String id = user.getUserId().toString();
        String name = user.getName();
        String profileImage = user.getProfileImage();

        response.setHeader("AccessToken", "bearer " + accessToken);
        //배포 시 아마존으로 변경해야 하는 부분

        getRedirectStrategy().sendRedirect(request, response, "아마존 s3와 연관된 주소값" + accessToken);
    }

    private String delegateAccessToken(String email) {
        Map<String, Object> claims = new HashMap<>();

        UserEntity user = userService.findByEmail(email);

        claims.put("email", user.getEmail());
        claims.put("userId", user.getUserId());

        String subject = user.getEmail();
        Date expiration = jwtTokenizer.getTokenExpiration(jwtTokenizer.getAccessTokenExpirationMinutes());

        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

        String accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

        return accessToken;
    }
}
