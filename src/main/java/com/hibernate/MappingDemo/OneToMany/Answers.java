package com.hibernate.MappingDemo.OneToMany;

import com.hibernate.MappingDemo.OneToOne.Question;
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
public class Answers {
    @Id
    @Column(name="answer_id")
    private int answerId;

    @Column(name = "answer")
    private String answer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "q_id")
    private Questions questions;

}
