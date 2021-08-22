import models.*;
import org.junit.*;
import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void employee_instantiatesCorrectly_true() {
        Employee eric = new Employee("Eric", "Senior","Manage Junior Developers", "IT");
        assertTrue(eric instanceof Employee);
    }

    @Test
    public void name_instantiatesWithName_name() {
        Employee eric = createEmployee1();
        assertEquals("Eric", eric.getName());
    }

    // HELPERS
    public Employee createEmployee1(){
        return new Employee("Eric", "Senior","Manage Junior Developers", "IT");
    }
}
