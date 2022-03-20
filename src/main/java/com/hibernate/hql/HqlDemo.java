package com.hibernate.hql;

import com.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HqlDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
//        List list = new ArrayList();
        //getQuery
        String query = "from Student s where name=:x and city=:y";
        Query<Student> query1 = session.createQuery(query, Student.class);
        query1.setParameter("x", "manu");
        query1.setParameter("y", "spn");
        List<Student> list = query1.list();
        list.stream().forEach(System.out::println);

        //delete query
        int i = session.createQuery("delete from Student s where s.name=:a")
                .setParameter("a", "Ankur")
                .executeUpdate();
        System.out.println("deleted: "+i);

        //updateQuery
        int i1 = session.createQuery("update Student s set city=:h where s.name=:m")
                .setParameter("m", "Monu")
                .setParameter("h", "Hardoi")
                .executeUpdate();
        System.out.println("rows updated: "+i1);
        transaction.commit();
        session.close();

    }
}
