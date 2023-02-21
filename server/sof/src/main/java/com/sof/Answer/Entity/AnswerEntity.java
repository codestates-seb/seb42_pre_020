package com.sof.Answer.Entity;

import com.sof.Users.Entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String answerId;

    @Column(nullable = false)
    private String detail;

    //@JoinColumn: Entity 또는 Collection 관계에서 조인 대상이 되는 Column을 나타낼 때 사용
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false, name = "create_dt")
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(nullable = false, name = "update_dt")
    private LocalDateTime updateDate = LocalDateTime.now();
}
