package com.sof.Score;

import com.sof.Answer.Entity.AnswerEntity;
import com.sof.Question.Entity.QuestionEntity;
import com.sof.Users.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public ScoreEntity findByUQ(UserEntity user, QuestionEntity question) {
        Optional<ScoreEntity> score = this.scoreRepository.findByUQ(user, question);

        if(score.isPresent()) { return score.get(); }
        else { return new ScoreEntity(); }
    }

    public ScoreEntity findByUA(UserEntity user, AnswerEntity answer) {
        Optional<ScoreEntity> score = this.scoreRepository.findByUA(user, answer);

        if(score.isPresent()) { return score.get(); }
        else { return new ScoreEntity(); }
    }

    public void saveScore(ScoreEntity score) { this.scoreRepository.save(score); }
}
