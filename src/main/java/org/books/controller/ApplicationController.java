package org.books.controller;

import org.books.model.Book;
import org.books.service.BookService;
import org.books.util.BookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {

    private BookUtil util;

    @Autowired
    public ApplicationController(BookUtil bookUtil) {
        this.util = bookUtil;
    }

    // home page mapping
    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

    /* New element creation page mapping */
    @RequestMapping("/new")
    public String newBook(Model model) {
        return "addBook";
    }

    /* Receives @param Book object, which is a
    * updated element, and save it */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book")Book book, Model model) {
        util.update(book);
        return "updateBook";
    }

    /* Return page for update, request parameter is a identifier of
    * already existed element, finds element from database by id,
    * and give this object as attribute for page */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String getUpdateForm(@RequestParam(value = "bookId") long bookId, Model model) {
        Book book = util.get(bookId);
        model.addAttribute("book", book);
        return "updateBook";
    }
}
