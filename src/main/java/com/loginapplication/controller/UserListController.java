package com.loginapplication.controller;

import com.loginapplication.dao.UserDao;
import com.loginapplication.model.User;
import com.loginapplication.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserListController {

	@Autowired
    private UserDao userDao;
	
    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public String userList(HttpSession session, Model model) {
        // Check if the user is authenticated and has admin role
        User user = (User) session.getAttribute("user");

       
            // Admin user, fetch user list from the database
            List<User> userList = userService.getAllUsers();
            model.addAttribute("userList", userList);
System.out.println("Admin .....");
            return "userList"; // JSP page name without extension
        
    }
    
    @PostMapping("/userList") // Update the endpoint
    public String deleteUser(@RequestParam("userId") int userId) {
        // You can add additional logic here before deleting if needed
        System.out.println("Delete controller called " + userId);
        userService.deleteUser(userId);

        // Do not use redirect here
        return "userList";
    }
    
    @GetMapping("/editUser")
    public String editUser(@RequestParam("userId") int userId, Model model) {
        // Fetch the user details by userId
        User user = userDao.getUserById(userId);
        System.out.println(userId + " This is userId");
        if (user != null) {
            model.addAttribute("user", user); // Add user object to the model
            return "editUser";
        } else {
            // User not found, redirect to user list page
            return "redirect:/userList";
        }
    }

    @PostMapping("/editUserUpdate")
    public String updateUser(@ModelAttribute("user") User user, Model model, RedirectAttributes redirectAttributes) {
    	 model.addAttribute("user");
     	System.out.println("userId = " + user.getUserId());
    	 if (user.getUserId() != null && !user.getUserId().equals("")) {
             userDao.updateUser(user);
             redirectAttributes.addFlashAttribute("successMessage", "User details updated successfully.");
             return "redirect:/userList";
         } else {
             // userId is null
             return "redirect:/userList";
         }
    }

}