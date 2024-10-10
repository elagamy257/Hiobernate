package com.luv2code.hibernate.dem;

import com.luv2code.hibernate.demo.entity.user;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryUserDemo {
    public static void main(String[] args) {


        SessionFactory sf=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(user.class)
                .buildSessionFactory();

        Session session= sf.getCurrentSession();
        try{

            session.beginTransaction();
            List<user> users=session.createQuery("from user").list();
            extracted(users);

            users=session.createQuery("from user s where  s.name='aya'").list();
            System.out.println(users);
            System.out.println("User who have name 'aya'");
            extracted(users);

            session.getTransaction().commit();
            System.out.println("done");
        }finally{
            session.close();
        }


    }

    private static void extracted(List<user> users) {
        for(user u: users){
            System.out.println(u);}
    }
}
