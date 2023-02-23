package com.sof.Question.Controller;

import com.sof.Answer.Controller.AnswerController;
import com.sof.Exception.UnauthorizedException;
import com.sof.Main.MainResponseDto;
import com.sof.Question.Dto.QuestionDto;
import com.sof.Question.Entity.QuestionEntity;
import com.sof.Question.Mapper.QuestionMapper;
import com.sof.Question.Service.QuestionService;
import com.sof.Security.Dto.TokenDto;
import com.sof.Tag.TagService;
import com.sof.Users.Entity.UserEntity;
import com.sof.Users.Mapper.UserMapper;
import com.sof.Users.Service.UserService;
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
    private final UserService userService;
    private final AnswerController answerController;
    private final TagService tagService;
    private final UserMapper userMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper, UserService userService, AnswerController answerController, TagService tagService, UserMapper userMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
        this.userService = userService;
        this.answerController = answerController;
        this.tagService = tagService;
        this.userMapper = userMapper;
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

        QuestionEntity question = questionService.create(questionMapper.questionPostDtoToQuestion(addQ), addQ.getTags(), user);

        QuestionDto.Response response = QuestionMapper.questionToQuestionResponse(question);

        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }

    @GetMapping("/questions")
    public ResponseEntity allQuestion() {
        List<QuestionEntity> questions = this.questionService.getQuestions();

        return new ResponseEntity<>
                (new MainResponseDto(questionMapper.QToBodyResponses(questions)), HttpStatus.OK);


    }

    //질문 상세 페이지
    @GetMapping("/questions/{questionId}")
    public ResponseEntity questionDetail(@PathVariable("questionId") Long id,
                                         @RequestHeader(value = "accessToken") String accessToken) {
        Boolean isWrite = false;

        if(!accessToken.equals("not")) {
            isWrite = questionService.getWrite(id, userService.findByAccessToken(accessToken));
        }
        QuestionEntity question = questionService.getDetail(id);
        UserEntity user = question.getUser();

        QuestionDto.QDetailResponse response = questionMapper.QDetailResponse(question, isWrite);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/questions/{questionId}")
    public ResponseEntity updateQuestion(@PathVariable("questionId") Long Id,
                                         @RequestBody QuestionDto.Patch patchDto) {
        QuestionEntity question = questionService.update(Id, patchDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable("questionId") Long Id,
                                         @RequestBody TokenDto requestBody) {

        //if문에는 본인이 아닌 작성한 질문이 아닐경우 처리 할 예외처리
        if(!questionService.TFQuestion(Id, userService.findByAccessToken(requestBody.getAccessToken()))){
            throw new UnauthorizedException("작성자가 아닙니다.");
        }

        //이 질문을 id기준으로 찾아야 함
        QuestionEntity question = this.questionService.find(Id);
        this.questionService.delete(Id);

        return  new ResponseEntity(HttpStatus.OK);



    }
}
