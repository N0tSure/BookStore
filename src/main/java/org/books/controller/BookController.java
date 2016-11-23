package org.books.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @RequestMapping(value = "/book/all", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getAllBooks() {
        return "All success";
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addBook(@RequestBody String json) {
        return "Add success: " + json;
    }

    @RequestMapping(value = "/book/remove", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String removeBook(@RequestBody String json) {
        return "Remove success: " + json;
    }

    @RequestMapping(value = "/book/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String updateBook(@RequestBody String json) {
        return "Update success: " + json;
    }
}
