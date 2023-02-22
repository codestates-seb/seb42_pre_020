package com.sof.Qusetion.QuestionDto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

public class QuestionDto {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Post{
        @NotBlank
        private String title;
        @NotBlank
        private String body;
        private List<String> tags;
        private String accessToken;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Patch{
        private String title;
        private String body;
        private List<String> tags;
        private String accessToken;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{
        private Long questionId;
        private Long userId;
        private String title;
        private String body;
        private List<Tag> tags;
        private LocalDateTime creat_dt;
        private LocalDateTime update_dt;
    }
}
