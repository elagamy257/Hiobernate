package com.luv2code.hibernate.dem;

import com.luv2code.hibernate.demo.entity.user;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateUserDemo {
    public static void main(String[] args) {


        SessionFactory sf=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(user.class)
                .buildSessionFactory();

        Session session= sf.getCurrentSession();
        try{

            int uerId=1;
            session=sf.getCurrentSession();
            session.beginTransaction();
            System.out.println("\ngetting user with id: "+uerId);
            user u=session.get(user.class, uerId);
            System.out.println("\nupdate user  ");
            u.getName("moza");
            session.getTransaction().commit();

            session=sf.getCurrentSession();
            session.beginTransaction();
            System.out.println("Update all name ");
//            session.createQuery("update user set name='zoz' ").executeUpdate();
            session.getTransaction().commit();

            System.out.println("done");
        }finally{
            session.close();
        }


    }
}
