package Assgn1FurtherProg.Assignment1.Models;

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

    public void setStudent(Students student) {
        this.student = student;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList<Students> getStudentEnrolmentList() {
        return studentEnrolmentList;
    }

    public void setStudentEnrolmentList(ArrayList<Students> studentEnrolmentList) {
        this.studentEnrolmentList = studentEnrolmentList;
    }
}
