package Entities;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name, id, belongClass, birth, faculty, phoneNumber, address;
    public List<Student> students;

    public Student(String name, String id, String belongClass, String birth, String faculty
            , String phoneNumber, String address) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.belongClass = belongClass;
        this.faculty = faculty;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBelongClass() {
        return belongClass;
    }

    public void setBelongClass(String belongClass) {
        this.belongClass = belongClass;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void AddStudent(Student student) {
        students.add(student);
    }

    public void DelStudent(String _id) {
        students.forEach(e -> {
            if(e.id.equals(_id)) {
                students.remove(e);
                return;
            }
        });
    }

    public void ChangeStudentInfo(String _id, String _name, String _belongClass, String _birth,
                                  String _faculty, String _phoneNumber, String _address) {
        students.forEach(e -> {
            if(e.id.equals(_id)) {
                setName(_name);
                setAddress(_address);
                setBirth(_birth);
                setBelongClass(_belongClass);
                setFaculty(_faculty);
                setPhoneNumber(_phoneNumber);
                return;
            }
        });
    }

    public Student GetStudentById(String _id) {
        Student ans = null;
        for(Student ptr : students) {
            if(ptr.id.equals(_id)) {
                ans = ptr;
                break;
            }
        }
        return ans;
    }

    public Student GetStudentByName(String _name) {
        Student ans = null;
        for(Student ptr : students) {
            if(ptr.name.equals(_name)) {
                ans = ptr;
                break;
            }
        }
        return ans;
    }
}
