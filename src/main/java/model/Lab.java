package model;

public class Lab {
    private int labId;
    private String labName;

    public Lab(int labId, String labName) {
        this.labId = labId;
        this.labName = labName;
    }

    public Lab(String labName) {
        this.labName = labName;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "labId=" + labId +
                ", labName='" + labName + '\'' +
                '}';
    }
}
