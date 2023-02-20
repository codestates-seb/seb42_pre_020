package com.sof.Qusetion.QuestionEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
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
    private List<String> tags = new ArrayList<>();
    @Column
    private LocalDateTime creat_dt;
    @Column
    private LocalDateTime update_dt;
}
