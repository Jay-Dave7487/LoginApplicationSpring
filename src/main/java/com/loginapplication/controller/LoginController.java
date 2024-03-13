package com.loginapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginapplication.model.User;
import com.loginapplication.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/LoginController")
    public String loginUser(HttpServletRequest request, Model model, HttpSession session) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (userService.isAdmin(email, password)) {
            // Admin login, redirect to userList page
            return "redirect:/userList";
        } else {
            // Normal user login
            User user = userService.getUserByEmail(email, password);

            if (user != null) {
                // User authenticated, store in session
                session.setAttribute("user", user);
                model.addAttribute("user", user);
                return "redirect:/userProfile";
            } else {
                // Invalid credentials, display error message
                model.addAttribute("errorMessage", "Invalid email or password");
                return "login"; // Redirect back to login page with error message
            }
        }
    }
}