package models;

public class User {
    public String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void createUser(String name) {
        this.name = name;
    }
}
