package org.books.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/* Test for homepage view*/
public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        ApplicationController appController = new ApplicationController(null);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(appController).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }
}
