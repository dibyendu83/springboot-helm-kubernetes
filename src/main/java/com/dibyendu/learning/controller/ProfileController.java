package com.dibyendu.learning.controller;

import com.dibyendu.learning.entiry.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String fetchProfileData(Model model, @AuthenticationPrincipal User user){
        String name = String.join(" ", user.getFirstname(), user.getLastname());
        model.addAttribute("page", "profile");
        model.addAttribute("name", name);
        model.addAttribute("user", user);
        return "profile";
    }
}
