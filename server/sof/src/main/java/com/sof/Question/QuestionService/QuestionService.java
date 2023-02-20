package com.sof.Question.QuestionService;

import com.sof.Question.QuestionEntity.QuestionEntity;
import com.sof.Question.QuestionRepository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final TagService tagService;
    private final UserService userService;

    public QuestionService(QuestionRepository questionRepository, TagService tagService, UserService userService) {
        this.questionRepository = questionRepository;
        this.tagService = tagService;
        this.userService = userService;
    }
    public QuestionEntity create(QuestionEntity question, List<String> tags, UserEntity user) //public 메서드타입 메서드명
    {
        question.setTitle(question.getTitle());
        question.setBody(question.getBody());
        question.setCrate_dt(LocalDateTime.now());
        question.setUpdate_dt(LocalDateTime.now());
        question.getUser(user());
        return this.questionRepository.save(question);
    }
    public List<QuestionEntity> getQuestions()
    {
        return this.questionRepository.findAll(); //전체질문조회
    }
    questionsToQuestionResponse
}
