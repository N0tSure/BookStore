package org.books.controller;

import org.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = {"org.books.service"})
public class BookController {

    private BookService service;

    @Autowired
    public BookController(BookService bookService) {
        this.service = bookService;
    }

    @RequestMapping(value = "/book/all", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getAllBooks() {
        return service.getAllBooks();
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addBook(@RequestBody String json) {
        return service.addBook(json);
    }

    @RequestMapping(value = "/book/remove", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String removeBook(@RequestBody String request) {
        return service.removeBook(request);
    }

    @RequestMapping(value = "/book/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String updateBook(@RequestBody String json) {
        return service.updateBook(json);
    }
}
