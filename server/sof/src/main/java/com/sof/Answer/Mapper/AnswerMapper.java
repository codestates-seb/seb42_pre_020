package com.sof.Answer.Mapper;

import com.sof.Answer.Dto.AnswerDto;
import com.sof.Answer.Entity.AnswerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {
    AnswerEntity PostDtoAnswer(AnswerDto.Post answerPostDto);

    AnswerEntity PatchDtoAnswer(AnswerDto.Patch answerPatchDto);

    /*
    default AnswerDto.Response AnswerResponseDto(AnswerEntity answer) {
        AnswerDto.Response response = new AnswerDto.Response(
                answer.getAnswerId(),
                answer.getDetail(),
                answer.getCreateDate(),
                answer.getQuestion().getQuestionId(),
                answer.isAccepted(),
                answer.getScore(),
                answer.getOwner()
        );
        return response;
    } */
}
