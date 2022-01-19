package com.hibernate.MappingDemo.OneToOne;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="question")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Question {
    @Id
    @Column(name="question_id")
    private int questionId;

    @Column(name = "question")
    private String question;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "a_id")
    private Answer answer;
}
