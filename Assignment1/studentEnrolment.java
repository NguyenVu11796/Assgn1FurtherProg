package Assignment1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class studentEnrolment {
    private Students student;
    private Courses course;
    private String Semester;

    public studentEnrolment(Students student, Courses course, String semester) {
        this.student = student;
        this.course = course;
        Semester = semester;
    }
}
