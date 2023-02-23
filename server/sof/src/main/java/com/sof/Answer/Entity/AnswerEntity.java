package com.sof.Answer.Entity;

import com.sof.Question.Entity.QuestionEntity;
import com.sof.Score.ScoreEntity;
import com.sof.Users.Dto.UserDto;
import com.sof.Users.Entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(nullable = false)
    private String detail;

    //@JoinColumn: Entity 또는 Collection 관계에서 조인 대상이 되는 Column을 나타낼 때 사용
    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false, name = "create_dt")
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(nullable = false, name = "update_dt")
    private LocalDateTime updateDate = LocalDateTime.now();

    @Column
    private boolean isAccepted;

    @Column
    private int score;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ScoreEntity> likeUsers;

    public UserDto.owner getOwner() {
        UserEntity user = this.user;

        UserDto.owner owner = new UserDto.owner(user.getUserId(), user.getName(), user.getProfileImage());

        return owner;
    }
}
