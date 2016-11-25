package org.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {
    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/new")
    public String newBook(Model model) {
        return "addBook";
    }
}
