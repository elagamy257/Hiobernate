package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String sql= "jdbc:mysql://localhost:3306/hibernate-app?useSSL=false";
        String user="root";
        String password="";
        try{
            System.out.println("Connecting to database..."+ sql);
            Connection con= DriverManager.getConnection(sql,user,password);
            System.out.println("Connected successfully !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
