package com.sof.Question.QuestionMapper;

//questionPostDtoToQuestion 기본형식

import com.sof.Question.QuestionDto.QuestionDto;
import com.sof.Question.QuestionEntity.QuestionEntity;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface QuestionMapper {
    default QuestionEntity questionPostDtoToQuestion(QuestionDto.Post post) {
        if (post == null) {
            return null;
        } else {
            QuestionEntity question = new QuestionEntity();//변수선언
            question.setTitle(post.getTitle());
            question.setBody(post.getBody());
            question.setTags(post.getTags());
            return question;
        }
    }
    default  QuestionDto.Response questionToQuestionResponse(QuestionEntity question)
    {
        QuestionDto.Response response = QuestionDto.Response
                .builder()
                .questionId(question.getQuestionId())
                .title(question.getTitle())
                .body(question.getBody())
                .tags(question.getTags())
                .creat_dt(question.getCrate_dt())
                .update_dt(question.getUpdate_dt())
                .build();
        return response;
    }

}