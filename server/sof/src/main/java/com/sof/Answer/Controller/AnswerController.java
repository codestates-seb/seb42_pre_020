package com.sof.Answer.Controller;

import antlr.Token;
import com.sof.Answer.Dto.AnswerDto;
import com.sof.Answer.Mapper.AnswerMapper;
import com.sof.Answer.Service.AnswerService;
import com.sof.Security.Dto.TokenDto;
import com.sof.Users.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController //Json 형태로 객체 데이터를 반환
@RequestMapping("/answers")
@Validated
@CrossOrigin
public class AnswerController {
    private final AnswerService answerService;
    private final UserService userService;
    private final QuestionService questionService;
    private final AnswerMapper mapper;

    public AnswerController(AnswerService answerService, UserService userService, QuestionService questionService, AnswerMapper mapper) {
        this.answerService = answerService;
        this.userService = userService;
        this.questionService = questionService;
        this.mapper = mapper;
    }

    //해당 id를 가진 질문에 답변 등록
    @PostMapping("/answers")
    public ResponseEntity postAnswer(@PathVariable Long id, @RequestBody AnswerDto.Post post) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //답변 수정
    @PatchMapping("/answers")
    public ResponseEntity patchAnswer(@PathVariable("id") @Positive Long answerId,
                                      @RequestBody AnswerDto.Patch patch) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //답변 삭제
    @DeleteMapping("/answers/{answerId}")
    public ResponseEntity deleteAnswer(@PathVariable("id") @Positive Long answerId,
                                       @RequestBody TokenDto tokenDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //추천 기능 = 좋아요

    //비추천 기능 = 싫어요
}
