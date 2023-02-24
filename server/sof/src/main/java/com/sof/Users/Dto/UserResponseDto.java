package com.sof.Users.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {
    private Long userId;
    private String email;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
