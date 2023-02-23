package com.sof.Question.Entity;

import com.sof.Answer.Entity.AnswerEntity;
import com.sof.Score.ScoreEntity;
import com.sof.Tag.TagEntity;
import com.sof.Users.Dto.UserDto;
import com.sof.Users.Entity.UserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column
    private int score;

    @Column
    private int viewCount;

    @Column
    private int answerCount;

    @Column
    private boolean isAnswered;

    @Column
    private LocalDateTime crate_dt;

    @Column
    private LocalDateTime update_dt;

    //연관관계 설정
    @ManyToMany
    @JoinTable(name = "question_tag")
    private List<TagEntity> tags = new ArrayList<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<AnswerEntity> answers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ScoreEntity> likeUser;

    public List<String> getTagStr() {
        List<String> tags = new ArrayList<>();

        for (int i = 0; i < this.tags.size(); i++) { tags.add(this.tags.get(i).getTag()); }

        return tags;
    }

    public UserDto.owner getOwner() {
        UserEntity user = this.user;

        UserDto.owner owner = new UserDto.owner(
                user.getUserId(), user.getName(), user.getProfileImage());

        return owner;
    }

    public QuestionEntity(String title, String body, List<TagEntity> tags) {
        this.title = title;
        this.body = body;
        this.tags = tags;
    }
}

