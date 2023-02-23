package com.sof.Question.Service;

import com.sof.Exception.DataNotFoundException;
import com.sof.Question.Dto.QuestionDto;
import com.sof.Question.Entity.QuestionEntity;
import com.sof.Question.Repository.QuestionRepository;
import com.sof.Tag.TagEntity;
import com.sof.Tag.TagService;
import com.sof.Users.Entity.UserEntity;
import com.sof.Users.Service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
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

    //질문 등록
    public QuestionEntity create(QuestionEntity question, List<String> tags, UserEntity user) //public 메서드타입 메서드명
    {
        question.setTitle(question.getTitle());
        question.setBody(question.getBody());
        question.setCrate_dt(LocalDateTime.now());
        question.setUpdate_dt(LocalDateTime.now());
        question.setUser(user);
        question.setScore(0);
        question.setViewCount(0);
        question.setAnswerCount(0);
        question.setAnswered(false);
        List<TagEntity> tagList = tagService.stringTags(question, tags);
        question.setTags(tagList);

        return this.questionRepository.save(question);
    }

    //질문 수정
    public QuestionEntity update(Long Id, QuestionDto.Patch patch) {
        QuestionEntity updateQ = find(Id);

        updateQ.setTitle(patch.getTitle());
        updateQ.setBody(patch.getBody());
        updateQ.setUpdate_dt(LocalDateTime.now());

        return this.questionRepository.save(updateQ);
    }

    //질문 삭제
    @Transactional
    public void delete(Long Id) {
        Optional<QuestionEntity> question = this.questionRepository.findById(Id);

        if (question.isPresent()) {
            this.questionRepository.deleteById(Id);
            tagService.deleteTagQ(question.get());
        }
        else { throw new DataNotFoundException("이미 삭제된 질문입니다."); }
    }

    public QuestionEntity find(Long Id) {
        Optional<QuestionEntity> findQ = this.questionRepository.findById(Id);

        if (findQ.isPresent()) { return findQ.get(); }
        else { throw new DataNotFoundException("질문을 찾을 수 없습니다."); }
    }

    //전체 질문 조회(날짜순으로)
    public List<QuestionEntity> getQuestions()
    {
        return this.questionRepository.findAllOrder();
    }

    public QuestionEntity getDetail(Long id) {
        QuestionEntity question = find(id);

        //질문 상세페이지 접속할 때마다 본 횟수 1씩 증가
        question.setViewCount(question.getViewCount() + 1);

        return this.questionRepository.save(question);
    }

    //검색 기능(일치하는 text)
    public List<QuestionEntity> search(String text) {
        List<QuestionEntity> answer = this.questionRepository.findByText(text);

        //날짜순으로 정렬
        Collections.sort(answer, new Comparator<QuestionEntity>() {
            @Override
            public int compare(QuestionEntity q1, QuestionEntity q2) {
                return q2.getCrate_dt().compareTo(q1.getCrate_dt());
            }
        });
        return answer;
    }

    public boolean TFQuestion(Long questionId, UserEntity user) {
        QuestionEntity question = questionRepository.findById(questionId).get();

        if(question.getUser() == user) { return true; }

        return false;
    }
}
