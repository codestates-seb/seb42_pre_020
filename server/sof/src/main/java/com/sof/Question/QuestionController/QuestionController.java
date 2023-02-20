package com.sof.Question.QuestionController;

import com.sof.Exception.UnauthorizedException;
import com.sof.Question.QuestionDto.QuestionDto;
import com.sof.Question.QuestionEntity.QuestionEntity;
import com.sof.Question.QuestionMapper.QuestionMapper;
import com.sof.Question.QuestionService.QuestionService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questions")


public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }
    //글작성
    @PostMapping("/questions")
    public ResponseEntity AddQuestions(@Validated @RequestBody QuestionDto.Post addQ) {
        //코드 들어갈 공간
        if (addQ.getAccessToken().equals("not")) {
            throw new UnauthorizedException("로그인이 필요합니다.");
        }
        UserEntity user = userService.findByAccessToken(addQ.getAccessToken());
        System.out.println(user.getEmail());

        QuestionEntity question = QuestionService.create(questionMapper.questionPostDtoToQuestion(addQ), addQ.getTags(), user);

        QuestionDto.Response response = QuestionMapper.questionToQuestionResponse(question);
        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }
    @GetMapping("/questions")
    public  ResponseEntity allQuestion(){
        List<QuestionEntity> questions = this.questionService.getQuestions();

        return new ResponseEntity<>
                (new ResponseDto(questionMapper.questionsToQuestionResponse(questions)),HttpStatus.OK);

        //수정기능 컨트롤러(update)
        //@patchMapping("/question")

        //삭제기능 컨트롤러(delete)
        //@DeleteMapping

        //

    }
}
