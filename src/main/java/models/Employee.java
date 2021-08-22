package models;

public class Employee extends User{
    private String position;
    private String role;
    private String department;
    private int id;

    public Employee(String name, String position, String role, String department) {
        super(name);
        this.position = position;
        this.role = role;
        this.department = department;
    }

    public String getPosition() {
        return position;
    }
}
