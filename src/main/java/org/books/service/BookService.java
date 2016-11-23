package org.books.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.books.util.BookUtil;
import org.books.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
public class BookService {

    private ObjectMapper mapper;
    private BookUtil bookUtil;

    @Autowired
    public BookService(BookUtil bookUtil) {
        this.bookUtil = bookUtil;
        this.mapper = new ObjectMapper();
    }

    public String getAllBooks() {
        String result;
        try {
            result = mapper.writeValueAsString(bookUtil.getAll());
        } catch (JsonProcessingException exc) {
            result = String.format("Something wrong with getting books: %s", exc.getMessage());
        }
        return result;
    }

    public String addBook(String json) {
        try {
            Book book = mapper.readValue(json, Book.class);
            bookUtil.add(book);
        } catch (IOException exc) {
            return String.format("Wrong input data format: %s", exc.getMessage());
        }
        return "Book's saving has been successful";
    }

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
