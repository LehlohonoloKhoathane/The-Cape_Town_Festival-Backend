package za.ac.uct.controllers;

public class DataObject {
    private String name;
    private int age;
    private String event;
    private String model;

    public DataObject() {
        this.name = "DefaultName";
        this.event = "DefaultEvent";
        this.model = "DefaultModel";
    }

    // Getters and Setters for each field

    public String getEvent(){
        return event;
    }

    public String getModel(){
        return model;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
