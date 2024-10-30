package com.dibyendu.learning.controller;

import com.dibyendu.learning.model.LoginRequest;
import com.dibyendu.learning.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@Slf4j
public class LoginController {

    private AuthService authService;

    @GetMapping("/")
    public String home() {
        return "redirect:/login";  // Redirect to login if not authenticated
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        Model model,  HttpServletRequest request) {
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("loginRequest", loginRequest);
        if(error != null){
            String loginError = (String) request.getSession().getAttribute("loginError");
            model.addAttribute("loginError", loginError);
        }
        return "login";  // Show the login page
    }

    @PostMapping("/login")
    public String loginUser(LoginRequest loginRequest, Model model) {
        authService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
        // Redirect to the home page upon successful login
        return "redirect:/home";  // after successful login go to home page
    }

}
