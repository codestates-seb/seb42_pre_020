package com.sof.Qusetion.QuestionRepository;

import com.sof.Qusetion.QuestionEntity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

}
