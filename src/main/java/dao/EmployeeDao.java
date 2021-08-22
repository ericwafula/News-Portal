package dao;

import models.Employee;
import models.News;

import java.util.List;

public interface EmployeeDao {
    // create
    void add(Employee employee);

    // read
    List<Employee> getAllEmployees();
    Employee findById(int id);
    List<News> userNews(int userId);

    // update


    // delete
    void deleteById(int id);
    void clearAll();
}
