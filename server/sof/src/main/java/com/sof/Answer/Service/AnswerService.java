package com.sof.Answer.Service;

import com.sof.Answer.Entity.AnswerEntity;
import com.sof.Answer.Repository.AnswerRepository;
import com.sof.Exception.DataNotFoundException;
import com.sof.Question.Entity.QuestionEntity;
import com.sof.Question.Service.QuestionService;
import com.sof.Score.ScoreService;
import com.sof.Users.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;
    private final ScoreService scoreService;

    public AnswerService(AnswerRepository answerRepository, QuestionService questionService, ScoreService scoreService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
        this.scoreService = scoreService;
    }

    //답변 등록
    public AnswerEntity create(Long id, AnswerEntity answer, UserEntity user) {
        QuestionEntity question = questionService.find(id);

        question.setAnswerCount(question.getAnswerCount() + 1);
        question.setAnswered(true);
        answer.setQuestion(question);
        answer.setScore(0);
        answer.setUser(user);
        answer.setAccepted(false);

        return answerRepository.save(answer);
    }

    public AnswerEntity update(Long answerId, AnswerEntity answer) {
        AnswerEntity findAnswer = findVerifiedAnswer(answerId);

        findAnswer.setDetail(answer.getDetail());
        findAnswer.setCreateDate(LocalDateTime.now());

        return answerRepository.save(findAnswer);
    }

    public void delete(Long answerId) {
        AnswerEntity answer = findVerifiedAnswer(answerId);
        QuestionEntity question = answer.getQuestion();
        question.setAnswerCount(answer.getQuestion().getAnswerCount() - 1);

        if(question.getAnswerCount() == 0) { question.setAnswered(false); }

    }

    public AnswerEntity findById(Long id) {
        return answerRepository.findById(id).get();
    }

    public AnswerEntity findVerifiedAnswer(Long answerId) {
        Optional<AnswerEntity> Answer = answerRepository.findById(answerId);

        if(Answer.isPresent()) { return Answer.get(); }
        else { throw new DataNotFoundException("질문을 찾을 수 없습니다!"); }
    }

    public boolean TFAnswer(Long answerId, UserEntity user) {
        AnswerEntity answer = answerRepository.findById(answerId).get();

        if(answer.getUser() == user) { return true; }

        return false;
    }
}
