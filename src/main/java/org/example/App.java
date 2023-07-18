package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main( String[] args ) {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            //вывод таблицы в консоль
//            List<Person> people = session.createQuery("SELECT p FROM Person p", Person.class).getResultList();
//            for (Person p : people) System.out.println(p);

            //вывод с условием
//            List<Person> people = session.createQuery("SELECT p FROM Person p where p.age>35", Person.class).getResultList();
//            for (Person p : people) System.out.println(p);

//            List<Person> people = session.createQuery("SELECT p FROM Person p where p.name LIKE 'S%' ", Person.class).getResultList();
//            for (Person p : people) System.out.println(p);

            //обновление
//            session.createQuery("UPDATE Person set age = 50 where name='Tom' ").
//            executeUpdate();

            //удаление
//            session.createQuery("Delete from Person where name='Tom' ").
//            executeUpdate();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
