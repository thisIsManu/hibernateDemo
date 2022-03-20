package com.hibernate.MappingDemo.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CascadeDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
                Questions questions = Questions.builder()
                .questionId(1)
                .question("Where do you live")
                .build();

        Answers ans1 = Answers.builder().answer("I live in spn").answerId(1).questions(questions).build();
        Answers ans2 = Answers.builder().answerId(2).answer("I live in Kanpur also.").questions(questions).build();
        List<Answers> answers = List.of(ans1, ans2);
        questions.setAnswer(answers);
        Transaction transaction = session.beginTransaction();
        session.save(questions);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
