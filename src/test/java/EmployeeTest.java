import models.*;
import org.junit.*;
import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void employee_instantiatesCorrectly_true() {
        Employee eric = new Employee("Eric", "Senior","Manage Junior Developers", 1);
        assertTrue(eric instanceof Employee);
    }

    @Test
    public void name_instantiatesWithName_name() {
        Employee eric = createEmployee1();
        assertEquals("Eric", eric.getName());
    }

    @Test
    public void position_instantiatesWithPosition_position() {
        Employee eric = createEmployee1();
        assertEquals("Senior", eric.getPosition());
    }

    @Test
    public void role_instantiatesWithRole_role() {
        Employee eric = createEmployee1();
        assertEquals("Manage Junior Developers", eric.getRole());
    }

    @Test
    public void department_instantiatesWithDepartment_department() {
        Employee eric = createEmployee1();
        assertEquals(1, eric.getDepartmentId());
    }

    @Test
    public void name_setsEmployeeName_department() {
        Employee eric = createEmployee1();
        eric.setName("Brian");
        assertEquals("Brian", eric.getName());
    }

    @Test
    public void employee_nameAndPositionAreTheSame() {
        Employee employee1 = createEmployee1();
        Employee employee2 = createEmployee1();
        assertEquals(true, employee1.equals(employee2));
    }

    // HELPERS
    public Employee createEmployee1(){
        return new Employee("Eric", "Senior","Manage Junior Developers", 1);
    }

    public Employee createEmployee2(){
        return new Employee("Becky", "Senior","Manage Junior Developers", 1);
    }
}
