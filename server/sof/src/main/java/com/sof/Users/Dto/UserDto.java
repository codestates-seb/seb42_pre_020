package com.sof.Users.Dto;

import com.sof.Users.Entity.UserEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    public static UserDto userDto;

    private Long userId;
    private String email;
    private String password;

    public String name;

    private UserEntity.UserStatus userStatus;
}
