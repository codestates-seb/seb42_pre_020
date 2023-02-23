package com.sof.Main;

import com.sof.Question.Dto.QuestionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class MainResponseDto {
    private final List<QuestionDto.QBodyResponse> items;

    public MainResponseDto(List<QuestionDto.QBodyResponse> items) {
        this.items = items;
    }
}
