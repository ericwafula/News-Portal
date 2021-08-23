import com.google.gson.Gson;
import static spark.Spark.*;

import dao.*;
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

        // create new department
        post("/departments/new", "application/json", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            departmentDao.add(department);
            response.status(201);
            response.type("application/json");
            return gson.toJson(department);
        });

        get("/departments/:departmentId", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("departmentId"));
            return gson.toJson(departmentDao.findById(departmentId));
        });

        get("/departments/:departmentId/users", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("departmentId"));
            return gson.toJson(departmentDao.allDepartmentEmployees(departmentId));
        });

        post("/departments/:departmentId/users/new", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("departmentId"));
            Department newDepartment = departmentDao.findById(departmentId);

            return gson.toJson(departmentDao.allDepartmentEmployees(departmentId));
        });

    }
}
