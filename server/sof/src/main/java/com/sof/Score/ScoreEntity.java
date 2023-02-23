package com.sof.Score;

import com.sof.Answer.Entity.AnswerEntity;
import com.sof.Question.Entity.QuestionEntity;
import com.sof.Users.Entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreId;

    @Column
    private int status = 0;

    @ManyToOne
    @JoinColumn(name = "question")
    private QuestionEntity question;

    @ManyToOne
    @JoinColumn(name = "answer")
    private AnswerEntity answer;

    @ManyToMany
    @JoinColumn(name = "user")
    private UserEntity user;
}
