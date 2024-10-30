package com.dibyendu.learning.controller;

import com.dibyendu.learning.entiry.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homepage(Model model, @AuthenticationPrincipal User user) {
        String name = String.join(" ", user.getFirstname(), user.getLastname());
        model.addAttribute("page", "home");
        model.addAttribute("name", name);
        model.addAttribute("email", user.getEmail());
        return "home";
    }
}
