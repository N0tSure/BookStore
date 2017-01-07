package org.books.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.books.util.BookUtil;
import org.books.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;

/* Allows work with DAO, Book entities and JSON messages */
@Service
public class BookService {

    private ObjectMapper mapper;
    private BookUtil bookUtil;

    @Autowired
    public BookService(BookUtil bookUtil) {
        this.bookUtil = bookUtil;
        this.mapper = new ObjectMapper();
    }

    /* This method allows get list of all books and
    * @return list of entities in JSON format */
    public String getAllBooks() {
        String result;
        try {
            result = mapper.writeValueAsString(bookUtil.getAll());
        } catch (JsonProcessingException exc) {
            result = String.format("Something wrong with getting books: %s", exc.getMessage());
        }
        return result;
    }

    /* Take string as @param which is JSON format
    * entity, @return success or error message consequently */
    public String addBook(String json) {
        try {
            Book book = mapper.readValue(json, Book.class);
            bookUtil.add(book);
        } catch (IOException exc) {
            return String.format("Wrong input data format: %s", exc.getMessage());
        }
        return "Book's saving has been successful";
    }

    /* Remove some book, by given @param which is it's id */
    public String removeBook(String request) {
        Long id;
        try {
            id = Long.valueOf(request);
        } catch (NumberFormatException exc) {
            return String.format("Wrong request: %s", request);
        }
        bookUtil.delete(id);
        return "Book successfully removed";
    }

    /* Updates already existing book, taken as @param
    * representation of entity in JSON format,
    * @return success or error message consequently */
    public String updateBook(String json) {
        try {
            Book book = mapper.readValue(json, Book.class);
            bookUtil.update(book);
        } catch (IOException exc) {
            return String.format("Wrong input data format: %s", exc.getMessage());
        }
        return "Book's updating has been successful";
    }

}
