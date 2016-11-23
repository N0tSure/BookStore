import org.books.controller.ApplicationController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class HoneControllerTest {
    @Test
    public void testHomePage() throws Exception {
        ApplicationController appController = new ApplicationController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(appController).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }
}
