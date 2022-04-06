package Assgn1FurtherProg.Assignment1.Interfaces;

import Assgn1FurtherProg.Assignment1.Models.Students;
import Assgn1FurtherProg.Assignment1.Models.studentEnrolment;
import Assgn1FurtherProg.Assignment1.Models.Courses;
import java.util.ArrayList;

/** Creating a public interface to define all available functionalities **/
public interface StudentEnrolmentManager {
    //Methods

    boolean addEnrolment(String studentID, String courseID, String semester);
    void deleteEnrolment(String studentID, String courseID, String semester);
    studentEnrolment getEnrolmentList(String studentID, String courseID, String semester);
    ArrayList<studentEnrolment> getEnrolments();
    Students getStudentByID(String studentID);
    ArrayList<Students> getStudents();
    ArrayList<Students> getStudentsInCourse(String courseID, String semester);
    Courses getCourseByID(String courseID);
    ArrayList<Courses> getCourses();
    ArrayList<Courses> getCoursesInSemester(String semester);
    ArrayList<Courses> getCoursesOfStudentInSemester(String studentID, String semester);
    void populateData();

}
