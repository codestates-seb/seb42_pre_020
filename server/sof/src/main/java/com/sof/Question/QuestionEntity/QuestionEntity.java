package com.sof.Question.QuestionEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;\\

@Entity
@Data
@NoArgsConstructor
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @Column(name="id")
    private Long userId;
    @Column
    private String title;
    @Column
    private String body;
    @Column
    private List<Tag> tags;
    @Column
    private LocalDateTime crate_dt;
    @Column
    private LocalDateTime update_dt;
}




}
