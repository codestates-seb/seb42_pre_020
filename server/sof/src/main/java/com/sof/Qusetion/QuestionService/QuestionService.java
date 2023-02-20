package com.sof.Qusetion.QuestionService;

import com.sof.Qusetion.QuestionEntity.QuestionEntity;
import com.sof.Qusetion.QuestionRepository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
    public QuestionEntity create(QuestionEntity question, List<String> tags, UserEntity user)
    {
        question.setTitle(question.getTitle());
        question.setBody(question.getBody());
        question.setUser(user);
        question.setCreat_dt(LocalDateTime.now());
        question.setUpdate_dt(LocalDateTime.now());
        return this.questionRepository.save(question);
    }
    public List<QuestionEntity> getQuestions()
    {
        return this.questionRepository.findAll();
    }
}
