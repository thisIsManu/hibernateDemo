package com.hibernate.MappingDemo.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Answer answer = Answer.builder().answer("Java is a programming language.").answerId(123).build();
        Question question= Question.builder().questionId(321).question("What is Java?").answer(answer).build();
        Transaction transaction = session.beginTransaction();
        session.save(question);
        session.save(answer);
        transaction.commit();

        Answer answer1 = session.get(Answer.class, 123);
        System.out.println(answer1.getAnswer());
        System.out.println(answer1.getQuestion().getQuestion());
        session.close();

    }
}
