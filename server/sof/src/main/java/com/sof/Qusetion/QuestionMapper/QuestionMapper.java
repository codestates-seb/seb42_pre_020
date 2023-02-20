package com.sof.Qusetion.QuestionMapper;

import com.sof.Qusetion.QuestionDto.QuestionDto;
import com.sof.Qusetion.QuestionEntity.QuestionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface QuestionMapper {
    default QuestionEntity questionPostDtoToQuestion(QuestionDto.Post post)
    {
        if (post == null)
        {
            return null;
        }
        else {
            QuestionEntity question = new QuestionEntity();
            question.setTitle(post.getTitle());
            question.setBody(post.getBody());
            question.setTags(post.getTags());
            return question;
        }
    }

    default QuestionDto.Response questionToQuestionResponse(QuestionEntity question)
    {
        QuestionDto.Response response = QuestionDto.Response
                .builder()
                .questionId(question.getQuestionId())
                .title(question.getTitle())
                .body(question.getBody())
                .tags(question.getTags())
                .creat_dt(question.getCreat_dt())
                .update_dt(question.getUpdate_dt())
                .build();
        return response;
    }
}
