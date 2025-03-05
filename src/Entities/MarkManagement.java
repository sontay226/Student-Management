package Entities;

import java.util.ArrayList;
import java.util.List;

public class MarkManagement {
    private List<Mark> marks = new ArrayList<>();

    public void AddMark(Mark mark) {
        marks.add(mark);
    }

    public void UpdateMark(String _studentId, String _subjectId, double _midMark, double _lastMark) {
        for(Mark ptr : marks) {
            if(ptr.studentId.equals(_studentId) && ptr.subjectId.equals(_subjectId)) {
                ptr.setMidMark(_midMark);
                ptr.setLastMark(_lastMark);
                System.out.println("Update success!");
                return;
            }
        }
        System.out.println("Update failed !");
    }
}
