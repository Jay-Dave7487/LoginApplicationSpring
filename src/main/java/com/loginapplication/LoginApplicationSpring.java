package com.loginapplication;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.loginapplication.model.User;

/**
 * Hello world!
 *
 */


public class LoginApplicationSpring {

    public static void main(String[] args) {
    	System.out.println("Yo");
          Configuration cfg = new Configuration();      
          cfg.configure("com/loginapplication/hibernate.cfg.xml");
          SessionFactory factory = cfg.buildSessionFactory();
          
          User user = new User();
       
          user.setFirstName("Leo");
//          user.setLastName("Messi");
//          user.setCountry("Arg");
//          user.setEmail("messi@gmail.com");
//          user.setHobby("football");
//          user.setLanguages("English");
//          user.setRole("user");
//          user.setMobileNo("923590989");
//          user.setPassword("leo");
//          user.setGender("male");
          
          System.out.println(user);
          
          Session session = factory.openSession();
          Transaction tx = session.beginTransaction();
          session.save(user);
          tx.commit();
          session.close();
    }
}


