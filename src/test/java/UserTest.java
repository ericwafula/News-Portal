import models.*;
import org.junit.*;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void user_instantiatesCorrectly_true() {
        User eric = new User("Eric");
        assertTrue(eric instanceof User);
    }

    @Test
    public void name_instantiatesWith_Name_true() {
        User eric = createUser1();
        assertEquals("Eric", eric.getName());
    }

    @Test
    public void name_createUser() {
        User user = createUser1();
        user.createUser("Dan");
        assertEquals("Dan", user.getName());
    }

    // HELPERS
    public User createUser1(){
        return new User("Eric");
    }
}
