import models.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DepartmentTest {
    @Test
    public void department_instantiatesCorrectly_true() {
        Department department1 = new Department("IT", "Focuses on IT related Stuff");
        assertTrue(department1 instanceof Department);
    }

    @Test
    public void name_instantiatesWithName_name() {
        Department department1 = createDepartment();
        assertEquals("IT", department1.getName());
    }

    @Test
    public void description_instantiatesWithDescription_description() {
        Department department = createDepartment();
        assertEquals("Focuses on IT related Stuff", department.getDescription());
    }

    @Test
    public void department_nameAndDescriptionAreTheSame() {
        Department department1 = createDepartment();
        Department department2 = createDepartment();
        assertEquals(true, department1.equals(department2));
    }



    // HELPERS
    public Department createDepartment(){
        return new Department("IT", "Focuses on IT related Stuff");
    }
}
