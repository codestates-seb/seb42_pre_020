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
        var oAuth2User = (OAuth2User) authentication.getPrincipal();

        System.out.println(oAuth2User.getAttributes().get("response"));
        String sub = "";
        String email = "";
        String name = "";

        if (oAuth2User.getAttributes().containsKey("response")) {
            String temp = oAuth2User.getAttributes().get("response").toString().replaceAll("\\{", "").replaceAll("}", "").replaceAll(", ", "=");
            String[] tempArr = temp.split("=");
            for (int i = 0; i < tempArr.length; i++) {
                if (tempArr[i].equals("id")) {
                    sub = tempArr[i + 1];
                } else if (tempArr[i].equals("email")) {
                    email = tempArr[i + 1];
                } else if (tempArr[i].equals("name")) {
                    name = tempArr[i + 1];
                }
            }
        } else {
            sub = String.valueOf(oAuth2User.getAttributes().get("sub"));
            email = String.valueOf(oAuth2User.getAttributes().get("email"));
            name = String.valueOf(oAuth2User.getAttributes().get("name"));
        }

        System.out.println(oAuth2User.getAttributes().toString());

        saveUser(sub, email, name);  // (5)
        redirect(request, response, email);  // (6)
    }

    private void saveUser(String sub, String email, String name) {
        UserEntity user = userService.findByEmailCreate(email);
        if (user == null) {
            user = new UserEntity();
            user.setEmail(email);
            user.setName(name);
            user.setCreateDate(LocalDateTime.now());
            user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("프리프젝20"));
            userService.createUser(user);
        }
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String email) throws IOException {
        String accessToken = delegateAccessToken(email);  // (6-1)
        UserEntity user = userService.findByEmail(email);

        String id = user.getUserId().toString();
        String name = user.getName();

        response.setHeader("AccessToken", "bearer " + accessToken);
        getRedirectStrategy().sendRedirect(request, response, " " + accessToken);   // (6-4)

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