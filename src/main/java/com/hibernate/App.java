package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException {
        System.out.println( "Project Running!" );
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Student.class)//add mapping in xml or use this
                .buildSessionFactory();
        System.out.println(factory.isClosed());
        Student student= Student.builder().id(123).city("Shahjahanpur").name("Manu").build();
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\mishr\\Desktop\\a1.jpg"));
        byte[] image = new byte[fis.available()];
        fis.read(image);


        Address address= Address.builder()
                .street("NH-24")
                .city("Shahjahanpur")
                .isOpen(true)
                .x(2350.25)
                .addedDate(new Date())
                .image(image)
                .build();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(address);
        session.save(student);
        transaction.commit();
        session.close();
        System.out.println(factory.isClosed());
    }
}
