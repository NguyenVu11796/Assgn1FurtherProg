package Assignment1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class studentEnrolment {
    private Students student;
    private Courses course;
    private String semester;
    private ArrayList<Students> studentEnrolmentList;

    public studentEnrolment(Students student, Courses course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public Students getStudent() {
        return student;
    }

    public Courses getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public ArrayList<Students> getStudentEnrolmentList() {
        return studentEnrolmentList;
    }
}
