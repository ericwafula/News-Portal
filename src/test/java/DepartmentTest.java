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
    public void name_setsName_name() {
        Department department = createDepartment();
        department.setName("Finance");
        assertEquals("Finance", department.getName());
    }

    @Test
    public void name_setsDescription_description() {
        Department department = createDepartment();
        department.setDescription("Focuses on IT related Stuff");
        assertEquals("Focuses on IT related Stuff", department.getDescription());
    }

    @Test
    public void department_setEmployeeCount() {
        Department department = createDepartment();
        department.setEmployee_count(2);
        assertEquals(2, department.getEmployee_count());
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
