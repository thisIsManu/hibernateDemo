package com.hibernate.MappingDemo.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
//        Answers answer = Answers.builder().answer("Java is a programming language.").answerId(1234).build();
//        Answers answer1 = Answers.builder().answer("Java is a programming language 1.").answerId(12345).build();
//        Answers answer2 = Answers.builder().answer("Java is a programming language 2.").answerId(12354).build();
//        Answers answer3 = Answers.builder().answer("Java is a programming language 3.").answerId(12312).build();
//        Questions question= Questions.builder().questionId(321).question("What is Java?").build();
//
//        List<Answers> list =new ArrayList<>();
//        answer.setQuestions(question);
//        answer1.setQuestions(question);
//        answer2.setQuestions(question);
//        answer3.setQuestions(question);
//        list.add(answer);
//        list.add(answer1);
//        list.add(answer2);
//        list.add(answer3);
//        Transaction transaction = session.beginTransaction();
//        question.setAnswer(list);
//        session.save(question);
//        session.save(answer);
//        session.save(answer1);
//        session.save(answer2);
//        session.save(answer3);
//
//        transaction.commit();
//
        Answers answers = session.get(Answers.class, 1234);

        System.out.println(answers.getQuestions());


        session.close();






    }
}
