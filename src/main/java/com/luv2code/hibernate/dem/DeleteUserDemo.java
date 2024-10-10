package com.luv2code.hibernate.dem;

import com.luv2code.hibernate.demo.entity.user;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteUserDemo {
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

            System.out.println("\ndeleting user : "+u);
            session.delete(u);
            System.out.println("\ngetting user with id: "+uerId);
            session.createQuery("delete from user where id=2").executeUpdate();

            session.getTransaction().commit();



            System.out.println("done");
        }finally{
            session.close();
        }


    }
}
