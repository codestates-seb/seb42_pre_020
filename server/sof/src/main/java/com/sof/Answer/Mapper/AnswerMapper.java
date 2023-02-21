package com.sof.Answer.Mapper;

import com.sof.Answer.Dto.AnswerDto;
import com.sof.Answer.Entity.AnswerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    AnswerEntity PostDtoAnswer(AnswerDto.Post answerPostDto);

    AnswerEntity PatchDtoAnswer(AnswerDto.Patch answerPatchDto);

    default AnswerDto.Response AnswerResponseDto(AnswerEntity answer) {
        AnswerDto.Response response = new AnswerDto.Response(
                answer.getAnswerId(),
                answer.getDetail(),
                answer.getCreateDate(),
                answer.getQuestion().getQuestionId()
        );
        return response;
    }
}
