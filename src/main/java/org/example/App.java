package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person p = new Person("new person2", 67);

            p.addItem(new Item("Item 1"));
            p.addItem(new Item("Item 2"));
            p.addItem(new Item("Item 3"));

//            p.setItems(new ArrayList<>(Collections.singleton(i)));
            //сохранение человека и связанных с ним товаров
//            session.persist(p);

            session.save(p);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
