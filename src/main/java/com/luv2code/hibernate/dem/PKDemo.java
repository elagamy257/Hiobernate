package com.luv2code.hibernate.dem;

import com.luv2code.hibernate.demo.entity.user;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PKDemo {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(user.class)
                .buildSessionFactory();

        try (Session session = sf.getCurrentSession()) {
            System.out.println("Creating users...");
            user u1 = new user();
            u1.setId(3);
            u1.setName("mostafa");
            user u2 = new user();
            u2.setId(4);
            u2.setName("elagamy");
            user u3 = new user();
            u3.setId(5);
            u3.setName("moza");


            session.beginTransaction();
            System.out.println("saved...");
            session.save(u1);
            session.save(u2);
            session.save(u3);
            session.getTransaction().commit();
            System.out.println("done");

        }
    }
}
