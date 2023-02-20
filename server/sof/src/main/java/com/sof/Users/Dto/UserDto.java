package com.sof.Users.Dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@NoArgsConstructor
public class UserDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class signup { //회원 가입
        @Email
        @NotBlank
        private String email; //이메일

        @NotBlank
        private String name; //회원 닉네임

        @NotBlank
        @Size(min = 5, max = 15)
        private String password; //회원 비밇번호
    }

    @Getter
    @Setter
    public static class login { //로그인
        @Email
        @NotBlank
        private String email; //아매알

        @NotBlank
        private String password; //회원 비밀번호
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class update { //수정
        @Email
        @NotBlank
        private String email; //이메일

        @NotBlank
        private String name; //회원 ID

        @NotBlank
        private String password; //회원 비밀번호
    }

    @Getter
    @AllArgsConstructor
    public static class response { //응답
        private Long userId;
        private String email;
        private String name;
        private LocalDateTime createDate;
    }

    @Getter
    @AllArgsConstructor
    public static class accessTokenResponse {
        private String accessToken;
        private Long userId;
        private String email;
        private String name;
    }
}
