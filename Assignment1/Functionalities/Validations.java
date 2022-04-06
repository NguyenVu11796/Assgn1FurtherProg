package Assgn1FurtherProg.Assignment1.Functionalities;

import Assgn1FurtherProg.Assignment1.Models.Courses;
import Assgn1FurtherProg.Assignment1.Models.Students;
import Assgn1FurtherProg.Assignment1.Models.studentEnrolment;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * This class is a collection of validators and condition checkers
 * To avoid repetition in execution.
 */
public class Validations {
    //Methods
    // 1) When populating the data or enrolling students in a course in a semester

    /**
     * Checks if a student is already in the student list of the semester
     * @param student: a Student object
     * @param studentsArrayList: a list of Student objects
     * @return true if a student is already enrolled in the list, false otherwise
     */
    public static boolean studentAlreadyEnrolled(Students student, ArrayList<Students> studentsArrayList) {
        for(Students studentInList: studentsArrayList) {
            if (studentInList.equals(student)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if a course is already available in course list.
     * @param course a Course object
     * @param courseList a list of Course objects.
     * @return true if a course is already available in course list, false otherwise.
     */
    public static boolean courseAlreadyExists(Courses course, ArrayList<Courses> courseList) {
        for (Courses courseInList: courseList) {
            if (courseInList.equals(course)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if an enrolment is already available in enrolment list.
     * @param enrolment an Enrolment object.
     * @param enrolmentList a list of Enrolment objects.
     * @return true if an enrolment is already available in enrolment list, false otherwise.
     */
    public static boolean enrolmentAlreadyExists(studentEnrolment enrolment, ArrayList<studentEnrolment> enrolmentList) {
        for (studentEnrolment sE: enrolmentList) {
            if (sE.getStudent().equals(enrolment.getStudent()) && sE.getCourse().equals(enrolment.getCourse()) && sE.getSemester().equalsIgnoreCase(enrolment.getSemester())) {
                return true;
            }
        }
        return false;
    }

    // 2) Validate user inputs

    /**
     * Checks if a student ID of the input student already in the student list
     * @param studentID: studentID of the input student
     * @param studentsArrayList: a list of Student objects
     * @return true if student ID already exists, false otherwise
     */
    public static boolean isStudentIDAvail(String studentID, ArrayList<Students> studentsArrayList) {
        for (Students st: studentsArrayList) {
            if (st.getStudentID().equalsIgnoreCase(studentID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a courseID of input courses exists in the course list
     * @param courseID: an ID of a Course
     * @param coursesArrayList: a list of Course objects
     * @return true if a courseID already exists, false otherwise
     */
    public static boolean isCourseIDAvail(String courseID, ArrayList<Courses> coursesArrayList) {
        for (Courses c : coursesArrayList) {
            if (c.getCourseID().equalsIgnoreCase(courseID)) {
                return true;
            }
        }
        return false;
    }
}
