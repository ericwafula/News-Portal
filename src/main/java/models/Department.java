package models;

public class Department {
    private String name;
    private String description;
    private int employee_count;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
