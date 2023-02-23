package com.sof.Score;

import com.sof.Answer.Entity.AnswerEntity;
import com.sof.Question.Entity.QuestionEntity;
import com.sof.Users.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {
    Optional<ScoreEntity> findByUQ(UserEntity user, QuestionEntity question);

    Optional<ScoreEntity> findByUA(UserEntity user, AnswerEntity answer);
}
