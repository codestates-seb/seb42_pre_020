package com.sof.Qusetion.QuestionController;

import com.sof.Exception.UnauthorizedException;
import com.sof.Qusetion.QuestionDto.QuestionDto;
import com.sof.Qusetion.QuestionEntity.QuestionEntity;
import com.sof.Qusetion.QuestionMapper.QuestionMapper;
import com.sof.Qusetion.QuestionService.QuestionService;
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
    //글 작성
    @PostMapping("/questions")
    public ResponseEntity AddQuestions(@Validated @RequestBody QuestionDto.Post addQ){
        if(addQ.getAccessToken().equals("not")){
            throw new UnauthorizedException("로그인이 필요합니다");
        }
        //user를 가져온다
        UserEntity user = UserService.findByAccessToken(addQ.getAccessToken());
        //user의 email을 가져온다
        System.out.println(user.getEmail());
        //질문작성
        QuestionEntity question = QuestionService.create(QuestionMapper.questionPostDtoToQuestion(addQ),
                                                            addQ.getTags(), user);
        QuestionDto.Response response = QuestionMapper.questionToQuestionResponse(question);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/questions")
    public ResponseEntity allQuestion(){
        List<QuestionEntity> questions = this.questionService.getQuestions();
        //매퍼부분 나중에 바뀔 수 있음
        return new ResponseEntity<>(new ResponseDto(QuestionMapper.questionToQuestionResponse(questions))
                                    , HttpStatus.OK);
    }
    //수정기능 컨트롤러(update)
    //@PatchMapping("/questions")

    //삭제기능 컨트롤러(delete)
    //@DeleteMapping("/questions")

    //
}
