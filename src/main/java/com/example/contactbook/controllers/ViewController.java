package com.example.contactbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    /**
     * Gets the index page
     * @return index page
     */
    @GetMapping("/index")
    public String viewIndexPage() {
        return "index";
    }

    /**
     * Gets the create contact page
     * @return contact page
     */
    @GetMapping("/createContact")
    public String connectToCreateContactPage() {
        return "createContact";
    }
    /**
     * Gets the create update page
     * @return update page
     */
    @GetMapping("/updateContact")
    public String connectToContactContactPage() {
        return "updateContact";
    }
}
