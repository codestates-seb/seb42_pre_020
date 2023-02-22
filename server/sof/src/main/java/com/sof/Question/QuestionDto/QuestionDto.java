package com.sof.Question.QuestionDto;

import lombok.*;
import org.aspectj.apache.bcel.generic.Tag;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

//조회,수정,삭제
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
        private String accessToken;

    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{
        private Long questionId;
        private Long userId;
        private String title;
        private String body;
        private List<Tag> tags;
        private LocalDateTime crate_dt;
        private LocalDateTime update_dt;

    }
}



