package g56514.webg5.chapterNineTeen.db;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import g56514.webg5.chapterNineTeen.model.User;

@WebMvcTest
public class UserRestTest {

    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private UserService userService;

    @Test
    public void getUserByName() throws Exception {
        String name = "MCD";
        User user = new User("ValidLogin", name);
        Mockito.when(userService.getUserByName(name)).thenReturn(user);
        mvc.perform(get("/api/user/MCD"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name));
    }
}
