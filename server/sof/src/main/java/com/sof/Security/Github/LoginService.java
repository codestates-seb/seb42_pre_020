package com.sof.Security.Github;

import com.sof.Security.Jwt.JwtTokenizer;
import com.sof.Users.Service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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
        OAuthMemberInfoResponse response;
    }
}
