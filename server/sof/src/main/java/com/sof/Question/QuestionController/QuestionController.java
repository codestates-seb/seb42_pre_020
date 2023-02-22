package com.sof.Question.QuestionController;

import com.nimbusds.oauth2.sdk.token.AccessToken;
import com.sof.Exception.UnauthorizedException;
import com.sof.Question.QuestionDto.QuestionDto;
import com.sof.Question.QuestionEntity.QuestionEntity;
import com.sof.Question.QuestionMapper.QuestionMapper;
import com.sof.Question.QuestionService.QuestionService;
import com.sof.Security.Dto.TokenDto;
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
    public ResponseEntity allQuestion() {
        List<QuestionEntity> questions = this.questionService.getQuestions();

        return new ResponseEntity<>
                (new ResponseDto(questionMapper.questionsToQuestionResponse(questions)), HttpStatus.OK);


    }

    @PatchMapping("/questions/{questionId}")
    public ResponseEntity updateQuestion(@PathVariable("questionId") Long Id,
                                         @RequestBody QuestionDto.Patch patchDto) {
        QuestionEntity question = questionService.update(Id, patchDto);

        return new ResponseEntity<>(HttpStatus.OK);

        //메퍼를써서 dto를 Entity로 바꾸고
        //엔티티를 서비스로 보낸다.
        //서비스에서 돌아온 엔티티를 다시 메퍼로 리스폰스 dto로 바꾸고
        //리스폰스 엔티티에 넣어서 보내준다.

        //질문 상세페이지 질문 id get하기

    }
    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable("questionId") Long Id,
                                         @RequestBody TokenDto requestBody) {

        //if문에는 본인이 아닌 작성한 질문이 아닐경우 처리 할 예외처리
        if(!questionService.){
        throw new UnauthorizedException("작성자가 아닙니다.");
        }
            //이 질문을 id기준으로 찾아야 함
        QuestionEntity question = this.questionService.find(Id);
        this.questionService.delete(Id);

        return  new ResponseEntity(HttpStatus.OK);



    }
}
