package com.hibernate.MappingDemo.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ManyToManyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee e1 = Employee.builder().eid(1).Name("Manu").build();
        Employee e2 = Employee.builder().eid(2).Name("Ajad").build();


        List<Employee> employeeList = List.of(e1, e2);
        Project p1= Project.builder().pid(3).projectName("Amex").build();
        Project p2= Project.builder().pid(4).projectName("Morgan").build();


        List<Project> projectList = List.of(p1, p2);
        e1.setProjects(projectList);
        p2.setEmployees(employeeList);
        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);

        transaction.commit();
        session.close();
    }
}
