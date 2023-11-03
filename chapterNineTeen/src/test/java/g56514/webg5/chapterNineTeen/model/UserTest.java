package g56514.webg5.chapterNineTeen.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    private BeanValidationUtil<User> validator;

    @Test
    public void loginValid() {
        User user = new User("ValidLogin", "Name");
        validator.assertIsValid(user);
    }

    @Test
    public void loginSizeLessThan6Error() {
        User user = new User("Login", "Name");
        validator.assertHasError(user, "login", Size.class);
    }

    @Test
    public void nameValid() {
        User user = new User("ValidLogin", "Name");
        validator.assertIsValid(user);
    }

    @Test
    public void nameBlankError() {
        User user = new User("ValidLogin", "");
        validator.assertHasError(user, "name", NotBlank.class);
    }

}
