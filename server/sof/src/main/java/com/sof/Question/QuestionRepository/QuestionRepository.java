package com.sof.Question.QuestionRepository;

import com.sof.Question.QuestionEntity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

}
