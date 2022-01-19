package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, 123);
        Student student2 = session.load(Student.class, 123);
        System.out.println(student);
        System.out.println(student2);
        Address address = session.get(Address.class, 1);
        System.out.println(address);
        transaction.commit();
        session.close();
    }
}
