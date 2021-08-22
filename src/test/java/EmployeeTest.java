import models.*;
import org.junit.*;
import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void employee_instantiatesCorrectly_true() {
        Employee eric = new Employee("Eric", "Senior","Manage Junior Developers", "IT");
        assertTrue(eric instanceof Employee);
    }
}
