package org.books.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.books.config.ApplicationConfig;
import org.books.config.HibernateConfig;
import org.books.config.application.WebConfig;
import org.books.model.Book;
import org.books.util.BookUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {ApplicationConfig.class, WebConfig.class, HibernateConfig.class})
public class BookServiceTest {

    @Autowired
    private BookUtil util;

    @Autowired
    private BookService service;

    private ObjectMapper mapper;

    @Before
    public void setUp() {
        if (mapper == null) mapper = new ObjectMapper();
    }

    @Test
    @Rollback
    @Transactional
    public void getAllTest() throws IOException {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Thinking in Java",10.1f,"desc","jjy",1100));
        books.add(new Book("Head First HTML5",18.3f,"html","jjy",800));
        books.add(new Book("Spring in Action", 15.2f, "description","rryhh",600));

        for (Book book : books) {
            util.add(book);
        }

        String json = service.getAllBooks();
        System.out.println(json);

        List<Book> deSerialized = mapper.readValue(json, new TypeReference<List<Book>>(){});
        assertTrue("List of books before serialization differs from list after this",
                deSerialized.containsAll(books));
    }

    @Test
    @Rollback
    @Transactional
    public void addBookTest() throws JsonProcessingException {
        Book original = new Book("Thinking in Java",10.1f,"desc","jjy",1100);
        String rawOriginal = mapper.writeValueAsString(original);

        String response = service.addBook(rawOriginal);
        assertTrue(String.format("addBookTest: Cached error signal from BookService: %s", response),
                response.contains("successful"));
    }

    @Test
    @Rollback
    @Transactional
    public void updateAndRemoveTest() throws JsonProcessingException {
        Book original = new Book("Thinking in Java",10.1f,"desc","jjy",1100);
        Book different = new Book("Head First HTML5",18.3f,"html","jjy",800);
        util.add(original);

        different.setId(original.getId());
        String rawDifferent = mapper.writeValueAsString(different);
        String response = service.updateBook(rawDifferent);
        assertTrue(String.format("After attempt to update book cached error signal from BookService: %s", response),
                response.contains("successful"));

        response = service.removeBook(different.getId().toString());
        assertTrue(String.format("After attempt to delete book cached error signal from BookService: %s", response),
                response.contains("successful"));
    }
}
