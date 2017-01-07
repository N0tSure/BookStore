package org.books.controller;

import org.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/* There mapped procedures for saving,
 * listing, updating and removing elements */
@RestController
@ComponentScan(basePackages = {"org.books.service"})
public class BookController {

    private BookService service;

    @Autowired
    public BookController(BookService bookService) {
        this.service = bookService;
    }

    /* Returns list of all books */
    @RequestMapping(value = "/book/all", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getAllBooks() {
        return service.getAllBooks();
    }

    /* Saves new book object in database */
    @RequestMapping(value = "/book/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addBook(@RequestBody String json) {
        return service.addBook(json);
    }

    /* Removes existed book from data base */
    @RequestMapping(value = "/book/remove", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String removeBook(@RequestBody String request) {
        return service.removeBook(request);
    }

    /* Allows to update already existed element */
    @RequestMapping(value = "/book/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String updateBook(@RequestBody String json) {
        return service.updateBook(json);
    }
}
