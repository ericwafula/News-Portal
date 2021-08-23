package models;

import java.util.Objects;

public class Department {
    private String name;
    private String description;
    private int employee_count;
    private int id;

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

    public int getEmployee_count() {
        return employee_count;
    }

    public int increaseEmployeeCount(){
        return this.employee_count++;
    }

    public int reduceEmployeeCount(){
        return this.employee_count--;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployee_count(int employee_count) {
        this.employee_count = employee_count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return employee_count == that.employee_count &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), employee_count);
    }
}
