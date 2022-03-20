package com.hibernate.cacheDemo;

import com.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CacheDemo{
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Student student = session1.get(Student.class, 1);
        session1.close();
        Session session2= sessionFactory.openSession();
        Student student2 = session2.get(Student.class, 1);
        session2.close();

        sessionFactory.close();

    }
}
