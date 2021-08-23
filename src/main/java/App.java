import com.google.gson.Gson;
import static spark.Spark.*;

import dao.*;
import exceptions.ApiException;
import models.*;
import org.sql2o.Connection;
import com.google.gson.Gson;
import org.sql2o.Sql2o;

public class App {

    public static void main(String[] args) {
        Sql2oDepartmentDao departmentDao = new Sql2oDepartmentDao();
        Sql2oEmployeeDao employeeDao = new Sql2oEmployeeDao();
        Sql2oNewsDao newsDao = new Sql2oNewsDao();

        Gson gson = new Gson();

        // get all departments
        get("/departments", "application/json", (request, response) -> {
            return gson.toJson(departmentDao.allDepartments());
        });

        // get department by id
        get("/departments/:departmentId", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("departmentId"));
            return gson.toJson(departmentDao.findById(departmentId));
        });

        // get all employees in a particular department
        get("/departments/:departmentId/employees", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("departmentId"));
            return gson.toJson(departmentDao.allDepartmentEmployees(departmentId));
        });

        // get a specific employee in a particular department
        get("/departments/:departmentId/users/:employeeId/details", "application/json", (request, response) -> {
            int employeeId = Integer.parseInt(request.queryParams("employeeId"));

            Employee employeeToFind = employeeDao.findById(employeeId);

            if (employeeToFind == null){
                throw new ApiException(404, String.format("No employee with id: \"%s\" exists", request.params("id")));
            }

            return gson.toJson(employeeToFind);
        });

        // get all employees
        get("/employees", "application/json", (request, response) -> {
            return gson.toJson(employeeDao.getAllEmployees());
        });

        // get specific employee details
        get("/employees/:employeeId/details", "appliaction/json", (request, response) -> {
            int employeeId = Integer.parseInt(request.params("employeeId"));

            Employee employeeToFind = employeeDao.findById(employeeId);

            if (employeeToFind == null){
                throw new ApiException(404, String.format("No employee with id: \"%s\" exists", request.params("id")));
            }

            return gson.toJson(employeeDao.findById(employeeId));
        });

        // create new department
        post("/departments/new", "application/json", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            departmentDao.add(department);
            response.status(201);
            response.type("application/json");
            return gson.toJson(department);
        });

        //Add employee to department
        post("/departments/:departmentId/employees/new", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("departmentId"));
            Department newDepartment = departmentDao.findById(departmentId);
            Employee newEmployee = gson.fromJson(request.body(), Employee.class);
            employeeDao.add(newEmployee);
            newEmployee.setDepartment(newDepartment.getName());
            departmentDao.addEmployeeToDepartment(newDepartment, newEmployee);
            response.status(201);
            response.type("application/json");
            return gson.toJson(newEmployee);
        });

    }
}
