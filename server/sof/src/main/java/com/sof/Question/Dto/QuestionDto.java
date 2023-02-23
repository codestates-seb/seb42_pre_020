package com.sof.Question.Dto;

import com.sof.Answer.Dto.AnswerDto;
import com.sof.Users.Dto.UserDto;
import lombok.*;
import org.aspectj.apache.bcel.generic.Tag;

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
        private String title;
        private String body;
        private List<Tag> tags;
        private boolean isAnswered;
        private int viewCount;
        private int answerCount;
        private int score;
        private LocalDateTime crate_dt;
        private LocalDateTime update_dt;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class QBodyResponse {
        private Long questionId;
        private String title;
        private String body;
        private List<String> tags;
        private UserDto.owner owner;
        private List<AnswerDto.Response> answers; //질문에 대한 답변
        private boolean isAnswered;
        private int viewCount;
        private int answerCount;
        private int score;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class QDetailResponse {
        private Long questionId;
        private String title;
        private String body;
        private List<String> tags;
        private UserDto.owner owner;
        private List<AnswerDto.Response> answers; //질문에 대한 답변
        private boolean isAnswered;
        private boolean isWrite;
        private int viewCount;
        private int answerCount;
        private int score;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
    }
}



