package com.luv2code.hibernate.dem;

import com.luv2code.hibernate.demo.entity.user;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadUserDemo {
    public static void main(String[] args) {


        SessionFactory sf=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(user.class)
                .buildSessionFactory();

        Session session= sf.getCurrentSession();
        try{
            System.out.println("Creating user...");
            user u1 = new user();
            u1.setId(2);
            u1.setName("Atef");
            session.beginTransaction();
            System.out.println("saved...");
            System.out.println(u1);
            session.save(u1);

            session.getTransaction().commit();
            System.out.println("saved...id:"+u1.getId(2));
            session = sf.getCurrentSession();
            session.beginTransaction();
            System.out.println("/n get user with id: "+u1.getId(2));
            user tempUser = session.get(user.class, u1.getId(2));
            System.out.println("get complete: "+tempUser);
            session.getTransaction().commit();

            System.out.println("done");
        }finally{
            session.close();
        }


    }
}
