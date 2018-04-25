package com.base.knowhow.controllers;

import com.base.knowhow.models.User;
import com.base.knowhow.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class SignInController {

    @Autowired
    private AuthenticationService service;

//    @GetMapping(value = "/signIn")
//    public String showSignInPage() {
//        return "signIn";
//    }

    @GetMapping("/signIn")
    public String login(@ModelAttribute("model") ModelMap model, Authentication authentication,
                        @RequestParam Optional<String> error) {
        if (authentication==null){
            System.out.println("THE FIRST AUTHENTICATION IS NULL");
        }
        if (authentication != null) {
            System.out.println("HERE REDIRECT IS HAPPENING");
            return "redirect:/";
        }
        model.addAttribute("error", error);
        return "signIn";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Authentication authentication) {
        if (authentication != null) {
            request.getSession().invalidate();
        }

        return "redirect:/signIn";
    }
    @GetMapping("/")
    public String root(Authentication authentication) {
        if (authentication == null){
            System.out.println("THE SECOND AUTHENTICATION IS NULL");
            return "redirect:/signIn";
        } else {
            System.out.println("THE USER IS FROM DB");
            User user = service.getUserByAuthentication(authentication);
//            model.addAttribute(service.getUserByAuthentication(authentication));
//            model.addAttribute("model",user.getFirstName());
            System.out.println("OUR USER'S NAME IS "+user.getFirstName());
        }
        return "index";
    }

}

