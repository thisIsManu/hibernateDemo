package com.hibernate.MappingDemo.OneToMany;

import com.hibernate.FetchDemo;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="question")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Questions {
    @Id
    @Column(name="question_id")
    private int questionId;

    @Column(name = "question")
    private String question;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questions")
    private List<Answers> answer;
}
