package dao;

import models.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oEmployeeDaoTest {
    private static Sql2oEmployeeDao employeeDao = new Sql2oEmployeeDao();

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void save_employeeSavesToDatabase() {
        Employee employee = newEmployee();
        assertNotEquals(0, employee.getId());
    }

    @Test
    public void find_findEmployee_employee(){
        Employee employee1 = newEmployee();
        Employee employee2 = newEmployee2();
        Employee foundEmployee = employeeDao.findById(employee1.getId());
        assertEquals(true, employee1.equals(foundEmployee));
    }

    @Test
    public void employee_getsAllEmployees() {
        Employee employee1 = newEmployee();
        Employee employee2 = newEmployee2();
        assertEquals(true, employeeDao.getAllEmployees().contains(employee1));
        assertEquals(true, employeeDao.getAllEmployees().contains(employee2));
    }

    @Test
    public void delete_deletesEmployeesFromDatabase() {
        Employee employee1 = newEmployee();
        Employee employee2 = newEmployee2();
        employeeDao.deleteById(employee1.getId());
        assertEquals(1, employeeDao.getAllEmployees().size());
    }

    @Test
    public void delete_deleteAllEmployees() {
        Employee employee1 = newEmployee();
        Employee employee2 = newEmployee2();
        employeeDao.clearAll();
        assertEquals(0, employeeDao.getAllEmployees().size());
    }

    private Employee newEmployee(){
        Employee employee = new Employee("Eric","Senior Dev","Manage Junior Devs", "IT");
        employeeDao.add(employee);
        return employee;
    }

    private Employee newEmployee2(){
        Employee employee = new Employee("Becky","Junior Dev","Complete daily tasks", "IT");
        employeeDao.add(employee);
        return employee;
    }
}
