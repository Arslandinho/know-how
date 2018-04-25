package com.base.knowhow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/main")
    public String showMain(){
        return "mainPage";
    }
}
