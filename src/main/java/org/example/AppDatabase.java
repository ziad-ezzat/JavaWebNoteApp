package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppDatabase {

    SessionFactory sessionFactory;

    public AppDatabase() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }
}
