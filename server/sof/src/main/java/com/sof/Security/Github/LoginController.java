package com.sof.Security.Github;

import com.sof.Security.Jwt.JwtTokenizer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;

@RestController
@CrossOrigin
public class LoginController {
    private final LoginService loginService;
    private final JwtTokenizer jwtTokenizer;

    public LoginController(LoginService loginService, JwtTokenizer jwtTokenizer) {
        this.loginService = loginService;
        this.jwtTokenizer = jwtTokenizer;
    }

    @GetMapping("/login/github")
    public void githubLogin(@PathParam("code") String code, HttpServletResponse response) throws IOException {
        GithubToken githubToken = loginService.getAccessToken(code);

        String[] all = loginService.getLogin(githubToken.getAccessToken());

        String accessToken  = all[0];
        String id = all[1];
        String name = all[2];
        String profileImage = all[3];
        String email = all[4];

        response.sendRedirect("s3 accessToken 주소" + accessToken);
    }

}
