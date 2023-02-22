package com.sof.Question.QuestionService;

import com.sof.Exception.DataNotFoundException;
import com.sof.Question.QuestionDto.QuestionDto;
import com.sof.Question.QuestionEntity.QuestionEntity;
import com.sof.Question.QuestionRepository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
        Optional<QuestionEntity> question = this.questionRepository.findById(Id);
        if (question.isPresent())
        {
            this.questionRepository.deleteById(Id);
        }
        else
            throw new = DataNotFoundException("이미 삭제된 질문입니다.");

    }
    //1. 저장소에서 질문을 아이디 기준으로 찾기 2.만약에 구문- optinal if문 조건에 값을 가지고 있는지 없는지 판단하기 3. if문 실행할 코드
    //4. 저장소에서 아이디 기준으로 질문 저장소에 있는 질문을 id기준으로 삭제 deleteByOptional 5.else 이미 삭제된 경우 throw new 쓰기
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
        return this.questionRepository.findAll(); //전체질문조회
    }
    questionsToQuestionResponse
}
