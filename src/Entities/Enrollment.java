package Entities;

public class Enrollment {
    private Student student;
    private Subject subject;
    private String semester;  // Ví dụ: "Học kỳ I", "Học kỳ II"

    public Enrollment(Student student, Subject subject, String semester) {
        this.student = student;
        this.subject = subject;
        this.semester = semester;
    }

    public Student getStudent() {return student;}

    public Subject getSubject() {return subject;}

    public String getSemester() {return semester;}

    @Override
    public String toString() {
        return "Enrollment{" +
               "student=" + student.getId() +
               ", subject=" + subject.getSubjectId() +
               ", semester='" + semester + '\'' +
               '}';
    }
}
