package model;

public class Tribble {
    private int tribbleId;
    private String name;
    private int age;
    private int size;
    private int labId;

    public Tribble(String name, int age, int size) {
        this.name = name;
        this.age = age;
        this.size = size;
    }

    public Tribble(String name, int age, int size, int labId) {
        this.name = name;
        this.age = age;
        this.size = size;
        this.labId = labId;
    }

    public Tribble(int tribbleId, String name, int age, int size, int labId) {
        this.tribbleId = tribbleId;
        this.name = name;
        this.age = age;
        this.size = size;
        this.labId = labId;
    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public int getTribbleId() {
        return tribbleId;
    }

    public void setTribbleId(int tribbleId) {
        this.tribbleId = tribbleId;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
