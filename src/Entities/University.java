package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class University {
    private List<Student> students;
    private List<Subject> subjects;
    private List<Grade> grades;
    private List<Enrollment> enrollments;

    public University() {
        students = new ArrayList<>();
        subjects = new ArrayList<>();
        grades = new ArrayList<>();
        enrollments = new ArrayList<>();
    }

    // student management
    public void AddStudent(Student student) {
        for(Student tmp : students) {
            if(tmp.getId().equals(student.getId())) {
                System.out.println("This id already exist!");
                return;
            }
        }
        students.add(student);
    }

    public void DelStudent(String _studentId) {
        students.removeIf(e -> (e.getId().equals(_studentId)));
    }

    public void UpdateStudentInfo(String _id, String _name, String _className, String _birth, String _faculty,
                                  String _phoneNumber, String _address) {
        students.forEach(e -> {
            if(e.getId().equals(_id)) {
                e.setName(_name);
                e.setAddress(_address);
                e.setClassName(_className);
                e.setBirth(_birth);
                e.setFaculty(_faculty);
                e.setPhoneNumber(_phoneNumber);
            }
        });
    }

    public Optional<Student> getStudentById(String _id) {
        return students.stream().filter(s -> s.getId().equals(_id)).findFirst();
    }

    public List<Student> getStudentByName(String _name) {
        return students.stream().filter(s -> s.getName().equalsIgnoreCase(_name))
                       .collect(Collectors.toUnmodifiableList());
    }

    // subject management
    public void AddSubject(Subject subject) {
        for(Subject tmp : subjects) {
            if(tmp.getSubjectId().equals(subject.getSubjectId())) {
                System.out.println("This id already exist!");
                return;
            }
        }
        subjects.add(subject);
    }

    public void DelSubject(String _id) {
        subjects.removeIf(e -> (e.getSubjectId().equals(_id)));
    }

    public void UpdateSubjectInfor(String _id, String _name, int _credits, String _teacher) {
        subjects.forEach(e -> {
            if(e.getSubjectId().equals(_id)) {
                e.setSubjectName(_name);
                e.setCredits(_credits);
                e.setTeacher(_teacher);
            }
        });
    }

    public Optional<Subject> getSubjectById(String _id) {
        return subjects.stream().filter(s -> s.getSubjectId().equals(_id)).findFirst();
    }

    public List<Subject> getSubjectByName(String _name) {
        return subjects.stream().filter(s -> s.getSubjectName().equalsIgnoreCase(_name)).collect(
                Collectors.toUnmodifiableList());
    }

    // enrollment management
    public boolean enrollStudentInSubject(String _studentId, String _subjectId, String semester) {
        Optional<Student> studentOpt = getStudentById(_studentId);
        Optional<Subject> subjectOpt = getSubjectById(_subjectId);
        if(studentOpt.isEmpty() && subjectOpt.isEmpty()) {
            System.out.println("Student or Subject not exist!");
            return false;
        }
        boolean isAlreadyEnrolled = enrollments.stream().anyMatch(e ->
                                                                          e.getStudent().getId()
                                                                           .equals(_studentId) && e.getSubject()
                                                                                                   .equals(_subjectId) && e.getSemester()
                                                                                                                           .equalsIgnoreCase(
                                                                                                                                   semester));
        if(isAlreadyEnrolled) {return false;}
        long count = enrollments.stream().filter(e -> e.getStudent().getId().equals(_studentId) && e.getSemester()
                                                                                                    .equalsIgnoreCase(
                                                                                                            semester))
                                .count();
        if(count >= 6) {return false;}
        enrollments.add(new Enrollment(studentOpt.get(), subjectOpt.get(), semester));
        return true;
    }

    public boolean cancelEnrollment(String studentId, String subjectId, String semester) {
        return enrollments.removeIf(e ->
                                            e.getStudent().getId().equals(studentId) &&
                                            e.getSubject().getSubjectId().equals(subjectId) &&
                                            e.getSemester().equalsIgnoreCase(semester)
                                   );
    }

    // grade management
    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public Optional<Grade> getGrade(String studentId, String subjectId) {
        return grades.stream().filter(g ->
                                              g.getStudent().getId().equals(studentId) &&
                                              g.getSubject().getSubjectId().equals(subjectId)
                                     ).findFirst();
    }

    public List<Grade> getGradesBySubject(String subjectId) {
        return grades.stream()
                     .filter(g -> g.getSubject().getSubjectId().equals(subjectId))
                     .collect(Collectors.toList());
    }

    // report
    public List<Grade> reportGradesBySubject(String _id) {
        return getGradesBySubject(_id);
    }

    public List<Grade> reportScholarshipStudents() {
        return grades.stream().filter(g -> g.getTotal() >= 8.0).collect(Collectors.toUnmodifiableList());
    }

    public List<Grade> reportStudentNeedImprove() {
        return grades.stream().filter(g -> g.getTotal() < 5.0).collect(Collectors.toUnmodifiableList());
    }

    // avd report
    public void reportEnrollmentCount(String semester) {
        System.out.println("Enrollment count for semester : " + semester);
        subjects.forEach(s -> {
            long count = enrollments.stream().filter(e -> e.getSubject().equals(s.getSubjectId()) &&
                                                          e.getSemester().equalsIgnoreCase(semester)).count();
            System.out.println(
                    "Subject : " + s.getSubjectName() + " ( " + s.getSubjectId() + " ) " + count + " students");
        });
    }
}
