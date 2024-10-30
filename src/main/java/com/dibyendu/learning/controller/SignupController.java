package com.dibyendu.learning.controller;

import com.dibyendu.learning.model.SignUpRequest;
import com.dibyendu.learning.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@AllArgsConstructor
public class SignupController {

    private UserService userService;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        SignUpRequest signUpRequest = new SignUpRequest();
        model.addAttribute("signUpRequest", signUpRequest);
        return "signup";  // Show the login page
    }

    @PostMapping("/signup")
    public String handleSignup(SignUpRequest signUpRequest, RedirectAttributes redirectAttributes){
        log.info("signup request = {} ", signUpRequest);
        userService.createUser(signUpRequest);

        // Add flash attributes to carry data across redirects
        redirectAttributes.addFlashAttribute("message", "Signup successful! Please log in.");
        redirectAttributes.addFlashAttribute("alertType", "success");

        // Redirect to the login page
        return "redirect:/login";
    }
}
