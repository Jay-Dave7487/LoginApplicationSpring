package com.loginapplication.controller;

import com.loginapplication.dao.UserDao;
import com.loginapplication.model.User;
import com.loginapplication.service.UserService;

import jakarta.servlet.http.HttpSession;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserProfileController {
	
	@Autowired
	UserDao userDao;

    @Autowired
    private UserService userService;

    @GetMapping("/userProfile")
    public String userProfile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            model.addAttribute("user", user);
            return "userProfile"; 
        } else {
            return "redirect:/login";
        }
    }
    @GetMapping("/editUserProfile")
    public String editUserProfile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

       
            model.addAttribute("user", user);
            
            return "editUserProfile";
    } 
    
    @PostMapping("/editUserProfileUpdate")
    public String editsave(@ModelAttribute("user") User user,Model model, RedirectAttributes redirectAttributes) {
            model.addAttribute("user");
    	if (user.getUserId() != null && !user.getUserId().equals("")) {
        	
            userDao.updateUser(user);
            redirectAttributes.addFlashAttribute("successMessage", "User details updated successfully.");
            return "userProfile";
        } else {
            // userId is null
            return "redirect:/editUserProfile";
        }
    }
}