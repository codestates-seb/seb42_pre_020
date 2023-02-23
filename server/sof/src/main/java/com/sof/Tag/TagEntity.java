package com.sof.Tag;

import com.sof.Question.Entity.QuestionEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column
    private String tag;

    //질문과 태그 관계 구현할 때 필요
    @ManyToMany(mappedBy = "tags")
    private List<QuestionEntity> questions = new ArrayList<>();

    //글 내의 태그를 추가할 때 필요한 생성자
    public TagEntity(String tag, QuestionEntity question) {
        this.tag = tag;
        this.questions.add(question);
    }
}
