package com.ServiCont.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ServiCont.entities.User;
import com.ServiCont.services.UserService;

@Controller
public class IndexFController {

    UserService userService;

    public IndexFController(UserService userService){
        this.userService=userService;
    }


    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            User user = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user", user);
        }
        
        return "index";
    }
    
}
