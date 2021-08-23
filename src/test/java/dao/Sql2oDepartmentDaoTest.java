package dao;

import models.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {
    private static Sql2oDepartmentDao departmentDao = new Sql2oDepartmentDao();
    private static Sql2oEmployeeDao employeeDao = new Sql2oEmployeeDao();

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void department_addDepartmentToDatabase() {
        Department department = createDepartment1();
        assertNotEquals(0, department.getId());
    }

    @Test
    public void department_getDepartment() {
        Department department1 = createDepartment1();
        Department department2 = createDepartment2();
        assertEquals(true, departmentDao.allDepartments().contains(department1));
        assertEquals(true, departmentDao.allDepartments().contains(department2));
    }

    @Test
    public void employee_addEmployeeToDepartment() {
        Department department = createDepartment1();
        Employee employee = createEmployee1();
        departmentDao.addEmployeeToDepartment(department, employee);
        assertEquals("Killa Coders", employee.getDepartment());
    }

    @Test
    public void delete_deletingAllDepartments() {
        Department department1 = createDepartment1();
        Department department2 = createDepartment2();
        departmentDao.clearAll();
        assertEquals(0, departmentDao.allDepartments().size());
    }


//



    private Department createDepartment1(){
        Department newDepartment = new Department("Killa Coders", "We turn code into gold");
        departmentDao.add(newDepartment);
        return newDepartment;
    }

    private Department createDepartment2(){
        Department newDepartment = new Department("Forex Traders", "We make the market cry");
        departmentDao.add(newDepartment);
        return newDepartment;
    }

    private Employee createEmployee1(){
        Employee employee = new Employee("Eric", "CEO", "Fund Manager", "Fundamental Analysis");
        employeeDao.add(employee);
        return employee;
    }

    private Employee createEmployee2(){
        Employee employee = new Employee("Becky", "co-CEO", "Fund Manager", "Technical Analysis");
        employeeDao.add(employee);
        return employee;
    }
}
