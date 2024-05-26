package com.melnikov.webapp.controller;

import com.melnikov.webapp.model.User;
import com.melnikov.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("authenticated", true);
            model.addAttribute("username", user.getLogin());
        } else {
            model.addAttribute("authenticated", false);
        }
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        Optional<User> existingUser = userService.findByLogin(user.getLogin());
        if (existingUser.isPresent()) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, HttpSession session, Model model) {
        logger.info("Attempting to log in user: " + user.getLogin());
        Optional<User> optionalUser = userService.findByLogin(user.getLogin());
        if (optionalUser.isPresent()) {
            logger.info("User found in database: " + optionalUser.get().getLogin());
            if (optionalUser.get().getPassword().equals(user.getPassword())) {
                logger.info("Passwords match for user: " + user.getLogin());
                session.setAttribute("user", optionalUser.get());
                return "redirect:/";
            } else {
                logger.warn("Password mismatch for user: " + user.getLogin());
            }
        } else {
            logger.warn("User not found: " + user.getLogin());
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    @PostMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}