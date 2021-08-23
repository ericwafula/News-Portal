package dao;

import models.*;

import java.util.List;

public interface DepartmentDao {
    // create
    void add(Department department);
    void addEmployeeToDepartment(Department department, Employee employee);

    // read
    Department findById(int id);
    List<Department> allDepartments();
    List<Employee> allDepartmentEmployees(int departmentId);
    List<News> allDepartmentNews(int departmentId);

    // update
    void updateEmployeeCount(Department department);

    // delete
    void deleteDepartmentById(int id);
    void deleteEmployeeFromDepartment(Department department, Employee employee);
    void deleteDepartmentNewsById(int departmentId, int newsId);
    void clearAll();
}
