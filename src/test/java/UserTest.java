import models.*;
import org.junit.*;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void user_instantiatesCorrectly_true() {
        User user = new User("Eric", "Manager","Manage day to day operations", "IT");
        assertTrue(user instanceof User);
    }


}
