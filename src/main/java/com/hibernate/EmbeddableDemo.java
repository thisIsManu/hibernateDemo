package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Certificate certificate = Certificate.builder()
                .course("Hibernate")
                .duration("1.5 hrs")
                .build();
        Student student= Student.builder()
                .id(123)
                .city("Shahajahanpur")
                .name("Manu Mishra")
                .certificate(certificate)
                .build();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }
}
