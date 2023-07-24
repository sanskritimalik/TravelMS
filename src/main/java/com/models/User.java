package main.java.com.models;

public class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
     this.name = name;
    }

    @Override
    public String toString() {
        return "Id -" + id + "Name -" + name;
    }
}
