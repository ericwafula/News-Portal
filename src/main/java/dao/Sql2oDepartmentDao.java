package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    public Sql2oDepartmentDao() {
    }


    @Override
    public void add(Department department) {

    }

    @Override
    public void addEmployeeToDepartment(Department department, Employee employee) {

    }

    @Override
    public Department findById(int id) {
        return null;
    }

    @Override
    public List<Department> allDepartments() {
        return null;
    }

    @Override
    public List<Employee> allDepartmentEmployees(int departmentId) {
        return null;
    }

    @Override
    public List<News> allDepartmentNews(int departmentId) {
        return null;
    }

    @Override
    public void updateEmployeeCount(Department department) {

    }

    @Override
    public void deleteDepartmentById(int id) {

    }

    @Override
    public void deleteEmployeeFromDepartment(Department department, Employee employee) {

    }

    @Override
    public void deleteDepartmentNewsById(int departMentId, int newsId) {

    }

    @Override
    public void clearAll() {

    }
}
