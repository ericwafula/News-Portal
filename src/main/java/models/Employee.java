package models;

public class Employee extends User{
    private String position;
    private String role;
    private int id;
    private int departmentId;
//    private String department;

    public Employee(String name, String position, String role, int departmentId) {
        super(name);
        this.position = position;
        this.role = role;
        this.departmentId = departmentId;
    }

    public String getPosition() {
        return position;
    }

    public String getRole() {
        return role;
    }

    public int getDepartmentId() {
        return departmentId;
    }


}
