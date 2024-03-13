package com.loginapplication.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.loginapplication.model.User;

@Component
public class UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    HibernateTemplate hibernateTemplate;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void createUser(User user) {
        System.out.println("I am called UserDao...");
        
        Session session = sessionFactory.getCurrentSession(); // Changed to getCurrentSession()
        Transaction trans = session.beginTransaction();
        session.save(user);
        trans.commit();
    }

    @Transactional
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession(); // Changed to getCurrentSession()
        Transaction trans = session.beginTransaction();
        session.update(user);
        trans.commit();
    }
//    
//    

//    @Transactional
//    public void updateUser(User user) {
////        Session session = sessionFactory.getCurrentSession();
////        Transaction trans = session.beginTransaction();
////
////        Query query = session.createQuery("UPDATE User SET " +
////                "country = :country, " +
////                "email = :email, " +
////                "firstName = :firstName, " +
////                "gender = :gender, " +
////                "hobby = :hobby, " +
////                "languages = :languages, " +
////                "lastName = :lastName, " +
////                "mobileNo = :mobileNo, " +
////                "password = :password, " +
////                "role = :role " +
////                "WHERE userId = :userId");
////
////        query.setParameter("country", user.getCountry());
////        query.setParameter("email", user.getEmail());
////        query.setParameter("firstName", user.getFirstName());
////        query.setParameter("gender", user.getGender());
////        query.setParameter("hobby", user.getHobby());
////        query.setParameter("languages", user.getLanguages());
////        query.setParameter("lastName", user.getLastName());
////        query.setParameter("mobileNo", user.getMobileNo());
////        query.setParameter("password", user.getPassword());
////        query.setParameter("user", user.getRole());
////        query.setParameter("userId", user.getUserId());
////
////        // Execute the update query
////        query.executeUpdate();
////
////        trans.commit();
//    	 Session session = sessionFactory.getCurrentSession();
//         Transaction trans = session.beginTransaction();
//    	hibernateTemplate.update(user);
//    	trans.commit();
//    }

    @Transactional
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession(); 
        Transaction trans = session.beginTransaction();
        session.delete(user);
        trans.commit();
    }
    
    public void deleteUser(int id)
    {
        Session session ;
        User user ;

        session = sessionFactory.getCurrentSession();
      Transaction trans =  session.beginTransaction();
        user = session.load(User.class,id);
        
        session.delete(user);

        //This makes the pending delete to be done
        session.flush() ;
        trans.commit();
        

    }

    @Transactional(readOnly = true)
    public User getUserById(int userId) {
        Session session = sessionFactory.getCurrentSession(); 
      Transaction trans =  session.beginTransaction();
        User user = session.get(User.class, userId);
        trans.commit();
        return user;
    }
    
    @Transactional(readOnly = true)
    public User getUserByEmail(String email,String password) {
        Session session = sessionFactory.getCurrentSession(); // Changed to getCurrentSession()
        session.beginTransaction();
        return session.createQuery("FROM User WHERE email = :email AND password = :password", User.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .uniqueResult();
        
    }

    @Transactional(readOnly = true)
    public boolean isAdmin(String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User admin = session.createQuery("FROM User WHERE email = :email AND password = :password AND role = 'admin'", User.class)
                      .setParameter("email", email)
                      .setParameter("password", password)
                      .uniqueResult();
        session.close();

        return admin != null;
    }

    
    @Transactional(readOnly = false)
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession(); // Changed to getCurrentSession()
        session.beginTransaction();
        List<User> users = session.createQuery("FROM User WHERE role = 'user'", User.class).getResultList();
        return users;
    }
    
}