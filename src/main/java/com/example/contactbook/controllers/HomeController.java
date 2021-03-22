package com.example.contactbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /**
     * Handles the root (/) endpoint
     * @return index page
     */
    @RequestMapping("/")
    private String viewIndexPage(){
        return "index";
    }
}
