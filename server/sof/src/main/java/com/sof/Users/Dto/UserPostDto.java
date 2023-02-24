package com.sof.Users.Dto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserPostDto {
    private String email;
    private String name;
    private String password;

    public UserPostDto(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}