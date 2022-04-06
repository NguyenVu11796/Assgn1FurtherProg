package Assgn1FurtherProg.Assignment1.Models;

import java.util.ArrayList;

public class studentEnrolment implements Model{
    // Attributes
    private Students student;
    private Courses course;
    private String semester;

    // Constructors
    public studentEnrolment(Students student, Courses course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    // Getters
    public Students getStudent() {
        return student;
    }

    public Courses getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    // To String Method override
    @Override
    public String toString() {
        return "studentEnrolment{" +
                "student=" + student +
                ", course=" + course +
                ", semester='" + semester + '\'' +
                '}';
    }

    //to CSV String method
    // TO CSV STRING METHODS
    /**
     * Returns attributes of the object with commas to be appended to CSV file.
     * @return the string of values joined with comma symbol.
     */
    @Override
    public String toCSVString() {
        return student.getStudentID() + "," + student.getStudentName() + "," + course.getCourseID() + "," + course.getCourseName() + "," + semester + "\n";
    }
}
