package com.loginapplication.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.loginapplication.dao.UserDao;
import com.loginapplication.model.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = false)
    public void saveUser(User user) {
        userDao.createUser(user); 
    }

    @Transactional(readOnly = true)
    public User getUserByEmail(String email,String password) {
        return userDao.getUserByEmail(email,password);
    }
    
    @Transactional(readOnly = true)
    public boolean isAdmin(String email, String password) {
        return userDao.isAdmin(email, password);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Transactional
    public void deleteUser(int userId) {
    	System.out.println("Delete service called");
        userDao.deleteUser(userId);
    }
    
    @Transactional
    public boolean updateUserProfile(Map<String, String> userProfileData) {
        // Extract user ID from the map if necessary
        int userId = Integer.parseInt(userProfileData.get("userId"));

        // Retrieve the user from the database
        User user = userDao.getUserById(userId);
        if (user == null) {
            return false; // User not found
        }

        // Update user profile fields
        user.setFirstName(userProfileData.get("firstName"));
        user.setLastName(userProfileData.get("lastName"));
        user.setGender(userProfileData.get("gender"));
        user.setEmail(userProfileData.get("email"));
        user.setMobileNo(userProfileData.get("mobileNo"));
        user.setPassword(userProfileData.get("password"));
        user.setHobby(userProfileData.get("hobby")); // Set hobby
        user.setLanguages(userProfileData.get("languages")); // Set languages
        user.setCountry(userProfileData.get("country")); // Set country
        // Update other fields as needed...

        // Save the updated user
        userDao.updateUser(user);
        return true; // Profile updated successfully
    }

    
    
}