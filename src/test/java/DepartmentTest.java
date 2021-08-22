import models.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DepartmentTest {
    @Test
    public void department_instantiatesCorrectly_true() {
        Department department1 = new Department("IT", "Focuses on IT related Stuff");
        assertTrue(department1 instanceof Department);
    }
}
