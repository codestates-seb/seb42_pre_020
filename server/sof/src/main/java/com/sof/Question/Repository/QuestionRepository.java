package com.sof.Question.Repository;

import com.sof.Question.Entity.QuestionEntity;
import com.sof.Tag.TagEntity;
import com.sof.Users.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
    Integer countByTags(TagEntity tag);

    List<QuestionEntity> findByUser(UserEntity user);

    @Query("SELECT Q FROM Question Q ORDER BY Q.createDate desc")
    List<QuestionEntity> findAllOrder();

    List<QuestionEntity> findByText(String keyword);

}
