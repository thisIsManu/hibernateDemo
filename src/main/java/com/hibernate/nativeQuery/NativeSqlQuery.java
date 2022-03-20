package com.hibernate.nativeQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class NativeSqlQuery {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        String query = "Select * from Student";

        List<Object[]> list = session.createSQLQuery(query).list();
        list.stream().forEach(i -> System.out.println(Arrays.deepToString(i)));
        session.close();
        sessionFactory.close();

    }
}
