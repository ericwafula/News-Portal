package dao;

import db.DB;
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
        try(Connection conn = DB.sql2o.open()){
            String sql = "INSERT INTO departments (name, description, employee_count) VALUES (:name, :description, :employeeCount)";
            int id = (int) conn.createQuery(sql, true)
                    .bind(department)
                    .addParameter("employee_count", department.getEmployee_count())
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex){
            System.out.println("Unable to add department" + ex);
        }
    }

    @Override
    public void addEmployeeToDepartment(Department department, Employee employee) {
        try(Connection conn = DB.sql2o.open()){
            String sql = "INSERT INTO departments_users(deptid, userid) VALUES (:departmentId, :employeeId)";
            conn.createQuery(sql)
                    .addParameter("departmentId", department.getId())
                    .addParameter("employeeId", employee.getId())
                    .executeUpdate();
            employee.setDepartment(department.getName());
        } catch (Sql2oException ex){
            System.out.println("Unable to add into department" + ex);
        }
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
