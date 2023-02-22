package com.sof.Qusetion.QuestionService;

import com.sof.Exception.DataNotFoundException;
import com.sof.Qusetion.QuestionDto.QuestionDto;
import com.sof.Qusetion.QuestionEntity.QuestionEntity;
import com.sof.Qusetion.QuestionRepository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public QuestionEntity update(QuestionDto.Patch patch, Long Id)
    {
        QuestionEntity updateQ = find(Id);
        updateQ.setTitle(patch.getTitle());
        updateQ.setBody(patch.getBody());
        updateQ.setUpdate_dt(LocalDateTime.now());
        return this.questionRepository.save(updateQ);
    }

    public QuestionEntity delete(Long Id)
    {
        Optional<QuestionEntity> question = this.questionRepository.findById(Id);//질문을 아이디 기준으로 찾음
        if (question.isPresent())
        {
            this.questionRepository.deleteById(Id);
        }
        else
        {
            throw new DataNotFoundException("이미 삭제된 질문 입니다");
        }
    }
    public QuestionEntity find(Long Id)
    {
        Optional<QuestionEntity> findQ = this.questionRepository.findById(Id);
        if (findQ.isPresent())
        {
            return findQ.get();
        }
        else
        {
            throw new DataNotFoundException("질문을 찾을 수 없습니다.");
        }
    }
    public List<QuestionEntity> getQuestions()
    {
        return this.questionRepository.findAll();
    }
}
