package com.luv2code.hibernate.dem;

import com.luv2code.hibernate.demo.entity.user;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDemo {
    public static void main(String[] args) {


        SessionFactory sf=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(user.class)
                .buildSessionFactory();

        Session session= sf.getCurrentSession();
        try{
            System.out.println("Creating user...");
            user u =new user();
            u.setId(1);
            u.setName("Aya");
            session.beginTransaction();
            System.out.println("saved...");
            session.save(u);
            session.getTransaction().commit();
            System.out.println("done");
        }finally{
            session.close();
        }


    }
}
