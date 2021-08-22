package models;

public class Employee extends User{
    private String position;
    private String role;
    private int id;
    private int departmentId;
    private String department;

    public Employee(String name, String position, String role, String department) {
        super(name);
        this.name = name;
        this.position = position;
        this.role = role;
        this.department = department;
//        this.departmentId = departmentId;
    }

    public String getPosition() {
        return position;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
