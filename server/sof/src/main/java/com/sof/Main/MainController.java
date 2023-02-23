package com.sof.Main;

import com.sof.Question.Dto.QuestionDto;
import com.sof.Question.Entity.QuestionEntity;
import com.sof.Question.Mapper.QuestionMapper;
import com.sof.Question.Service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@CrossOrigin
public class MainController {
    private final QuestionService questionService;

    private final QuestionMapper mapper;

    public MainController(QuestionService questionService, QuestionMapper mapper) {
        this.questionService = questionService;
        this.mapper = mapper;
    }

    //검색 기능
    @GetMapping("/search")
    public ResponseEntity searchQ(@RequestParam(value = "q") String q) {
        List<QuestionEntity> questions = questionService.search(q);

        List<QuestionDto.QBodyResponse> response = this.mapper.QToBodyResponses(questions);

        return new ResponseEntity<>(new MainResponseDto(response), HttpStatus.OK);
    }

    //Tag 검색
    @GetMapping("/search/tag")
    public ResponseEntity tagSearch(@RequestParam(value = "tag") String tag) {
        List<QuestionEntity> questions = questionService.getQByTag(tag);
        List<QuestionDto.QBodyResponse> response = this.mapper.QToBodyResponses(questions);

        return new ResponseEntity<>(new MainResponseDto(response), HttpStatus.OK);
    }

    //유저 검색
    @GetMapping("/search/user/{userId}")
    public ResponseEntity userSearch(@PathVariable("userId") Long userId) {
        List<QuestionEntity> questions = questionService.getQByUser(userId);
        List<QuestionDto.QBodyResponse> response = this.mapper.QToBodyResponses(questions);

        return new ResponseEntity<>(new MainResponseDto(response), HttpStatus.OK);
    }
}
