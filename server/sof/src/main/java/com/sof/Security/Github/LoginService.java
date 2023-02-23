package com.sof.Security.Github;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sof.Security.Jwt.JwtTokenizer;
import com.sof.Users.Entity.UserEntity;
import com.sof.Users.Service.UserService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    private final UserService userService;
    private final JwtTokenizer jwtTokenizer;

    private String url = " ";
    private String clientId = " ";
    private String clientSecret = " ";

    public LoginService(UserService userService, JwtTokenizer jwtTokenizer) {
        this.userService = userService;
        this.jwtTokenizer = jwtTokenizer;
    }

    public GithubToken getAccessToken(String code) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        Map<String, String> header = new HashMap<>();
        headers.setAll(header);

        MultiValueMap<String, String> requestPayloads = new LinkedMultiValueMap<>();
        Map<String, String> requestPayload = new HashMap<>();
        requestPayload.put("client_id", clientId);
        requestPayload.put("client_secret", clientSecret);
        requestPayload.put("code", code);
        requestPayloads.setAll(requestPayload);

        HttpEntity<?> request = new HttpEntity<>(requestPayloads, headers);
        ResponseEntity<?> response = new RestTemplate().postForEntity(url, request, GithubToken.class);
        return (GithubToken) response.getBody();
    }

    public String[] getLogin(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        OAuthMemberInfoResponse response = restTemplate.exchange("github 주소", HttpMethod.GET, request, OAuthMemberInfoResponse.class).getBody();

        String email = response.getEmail();

        if(email.equals(null)) {
            email = "github" + response.getId() + "@github.com";
        }
        String name = response.getName();
        //String profileImage = response.getProfileImage();

        UserEntity user = userService.findByEmailCreate(email);

        if(user == null) {
            user = new UserEntity();
            user.setEmail(email);
            user.setName(name);
            user.setCreateDate(LocalDateTime.now());
            user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("프리20 화이팅!"));

            userService.createUser(user);
        }
        String jwtToken = delegateAccessToken(user);

        return new String[] {jwtToken, user.getUserId().toString(), user.getName(), user.getEmail()};
    }

    private String delegateAccessToken(UserEntity user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("userId", user.getUserId());

        String subject = user.getEmail();

        Date expiration = jwtTokenizer.getTokenExpiration(jwtTokenizer.getAccessTokenExpirationMinutes());

        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

        String accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

        return accessToken;
    }

    @Getter
    @NoArgsConstructor
    static class OAuthMemberInfoResponse {
        @JsonProperty("name")
        private String name;

        @JsonProperty("id")
        private String id;

        @JsonProperty("email")
        private String email;
    }
}
