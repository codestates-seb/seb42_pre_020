package com.sof.Answer.Dto;

import com.sof.Users.Dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class AnswerDto {

    @Getter
    @Setter
    public static class Post {
        @NotBlank
        private String detail;
        private String accessToken;
    }

    @Getter
    @Setter
    public static class Patch {
        private String detail;
        private String accessToken;
    }

    @AllArgsConstructor
    @Getter
    @Builder
    public static class Response {
        private Long answerId;
        private String detail;
        private Long questionId;
        private LocalDateTime createDate;
        private int score;
        private boolean isAccepted;
        private UserDto.owner owner;
    }
}
