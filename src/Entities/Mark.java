package Entities;

public class Mark {
    private double midMark, lastMark;
    public String studentId, subjectId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public double getMidMark() {
        return midMark;
    }

    public void setMidMark(double midMark) {
        this.midMark = midMark;
    }

    public double getLastMark() {
        return lastMark;
    }

    public void setLastMark(double lastMark) {
        this.lastMark = lastMark;
    }

    public Mark(double midMark, double lastMark) {
        this.lastMark = lastMark;
        this.midMark = midMark;
    }

    public double totalMark(double midMark, double lastMark) {
        return (midMark * 0.4) + (lastMark * 0.6);
    }

    @Override
    public String toString() {
        return "Student id : " + studentId + "Subject id : " + subjectId + " MidMark : " + midMark + " LastMark : " + lastMark + " TotalMark : " + totalMark(
                midMark, lastMark);
    }
}

