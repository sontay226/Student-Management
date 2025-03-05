package Entities;

public class Subject {
    private String subjectId;
    private String subjectName;
    private int credits;
    private String teacher;

    public Subject(String subjectId, String subjectName, int credits, String teacher) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.credits = credits;
        this.teacher = teacher;
    }

    // Getters & Setters
    public String getSubjectId() {return subjectId;}

    public void setSubjectId(String subjectId) {this.subjectId = subjectId;}

    public String getSubjectName() {return subjectName;}

    public void setSubjectName(String subjectName) {this.subjectName = subjectName;}

    public int getCredits() {return credits;}

    public void setCredits(int credits) {this.credits = credits;}

    public String getTeacher() {return teacher;}

    public void setTeacher(String teacher) {this.teacher = teacher;}

    @Override
    public String toString() {
        return "Subject{" +
               "subjectId='" + subjectId + '\'' +
               ", subjectName='" + subjectName + '\'' +
               ", credits=" + credits +
               ", teacher='" + teacher + '\'' +
               '}';
    }
}
