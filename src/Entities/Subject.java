package Entities;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String subjectId, subjectName, subjectPart, subjectTeacher;
    public List<Subject> subjects;

    public Subject(String _id, String _name, String _part, String _teacher) {
        this.subjectId = _id;
        this.subjectName = _name;
        this.subjectPart = _part;
        this.subjectTeacher = _teacher;
        subjects = new ArrayList<>();
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectPart() {
        return subjectPart;
    }

    public void setSubjectPart(String subjectPart) {
        this.subjectPart = subjectPart;
    }

    public String getSubjectTeacher() {
        return subjectTeacher;
    }

    public void setSubjectTeacher(String subjectTeacher) {
        this.subjectTeacher = subjectTeacher;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void AddSubject(Subject subject) {
        subjects.add(subject);
    }

    public void ChangSubjectsInfo(String _id, String _name, String _part, String _teacher) {
        subjects.forEach(e -> {
            if(e.subjectId.equals(_id)) {
                e.setSubjectName(_name);
                e.setSubjectPart(_part);
                e.setSubjectTeacher(_teacher);
            }
        });
    }

    public void DelSubject(String _id) {
        subjects.removeIf(e -> e.subjectId.equals(_id));
    }

    public Subject GetSubjectById(String _id) {
        Subject ans = null;
        for(Subject ptr : subjects) {
            if(ptr.subjectId.equals(_id)) {
                ans = ptr;
                break;
            }
        }
        return ans;
    }

    public Subject GetSubjectByName(String _name) {
        Subject ans = null;
        for(Subject ptr : subjects) {
            if(ptr.subjectId.equals(_name)) {
                ans = ptr;
                break;
            }
        }
        return ans;
    }
}
