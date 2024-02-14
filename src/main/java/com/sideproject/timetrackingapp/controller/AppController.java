package com.sideproject.timetrackingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController 
{
    @GetMapping("/")
    public String viwHomePage() 
    {
        return "index";
    }

    @GetMapping("/login")
    public String login() 
    {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register() 
    {
        return "auth/register";
    }
}
