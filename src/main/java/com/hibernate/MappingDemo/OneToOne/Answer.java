package com.hibernate.MappingDemo.OneToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@Builder
@Getter
@Setter
@ToString
public class Answer {
    @Id
    @Column(name="answer_id")
    private int answerId;

    @Column(name = "answer")
    private String answer;

    @OneToOne(mappedBy = "answer")
    private Question question;
}
