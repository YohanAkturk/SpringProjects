package be.he2b.scrum.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.CoreMatchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
public class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void iniProjects() throws Exception {
        mockMvc.perform(get(("/projects")))
        .andExpect(status().isOk())
        // .andExpect(view().name("project")) // le nom du fichier .html
        .andExpect(content().string(containsString("Othello")));
    }

    @Test
    public void addStoryWhenProjectOpen() throws Exception {
        // mockMvc.perform(get("/projects/Stratego/addStory"))
    }


    @Test
    public void addStoryWhenProjectClosed() throws Exception {

    }
}
