package Entities;

public class Grade {
    private Student student;
    private Subject subject;
    private double midterm;
    private double finalExam;
    private double total;

    public Grade(Student student, Subject subject, double midterm, double finalExam) {
        this.student = student;
        this.subject = subject;
        this.midterm = midterm;
        this.finalExam = finalExam;
        this.total = calculateTotal();
    }

    // Phương thức tính điểm tổng kết
    private double calculateTotal() {
        return midterm * 0.4 + finalExam * 0.6;
    }

    // Cập nhật điểm và tính lại tổng kết
    public void updateGrades(double midterm, double finalExam) {
        this.midterm = midterm;
        this.finalExam = finalExam;
        this.total = calculateTotal();
    }

    // Getters
    public Student getStudent() {return student;}

    public Subject getSubject() {return subject;}

    public double getMidterm() {return midterm;}

    public double getFinalExam() {return finalExam;}

    public double getTotal() {return total;}

    @Override
    public String toString() {
        return "Grade{" +
               "student=" + student.getId() +
               ", subject=" + subject.getSubjectId() +
               ", midterm=" + midterm +
               ", finalExam=" + finalExam +
               ", total=" + total +
               '}';
    }
}
