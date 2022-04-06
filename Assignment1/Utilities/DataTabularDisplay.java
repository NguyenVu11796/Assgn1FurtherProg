package Assgn1FurtherProg.Assignment1.Utilities;

import Assgn1FurtherProg.Assignment1.Models.Students;
import Assgn1FurtherProg.Assignment1.Models.Courses;
import Assgn1FurtherProg.Assignment1.Models.studentEnrolment;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataTabularDisplay {
    //Attribute(s)
    private static TableDisplay table;

    //Methods

    /**
     * Display the search results of students in a tabular format
     * @param studentSearch list of search results of students
     */
    public static void displayStudentSearch(ArrayList<Students> studentSearch) {
        table = new TableDisplay(); // create new instance of table attribute

        //Set up the tabular format
        table.setHeaders("Student ID", "Student Name", "Birthday");
        for (Students student: studentSearch) {
            table.addRow(student.getStudentID(), student.getStudentName(), student.getStudentBirthday());
        }

        // print out the student table
        table.print();
    }

    /**
     * Display the list of selected courses in table format.
     * @param courseResults list of selected courses.
     */
    public static void displayCourseResult(ArrayList<Courses> courseResults) {
        table = new TableDisplay();

        // Setup table
        table.setHeaders("Course ID", "Course name", "Credits");
        for (Courses course : courseResults) {
            table.addRow(course.getCourseID(), course.getCourseName(), Integer.toString(course.getNumberOfCredits()));
        }

        // Print the table
        table.print();
    }

    /**
     * Display the list of selected enrolments in table format.
     * @param enrolmentResults: list of selected enrolments.
     */
    public static void displayEnrolmentResult(ArrayList<studentEnrolment> enrolmentResults) {
        table = new TableDisplay();

        // Setup table
        table.setHeaders("Student ID", "Student name", "Course ID", "Course name", "Semester");
        for (studentEnrolment sE : enrolmentResults) {
            table.addRow(sE.getStudent().getStudentID(), sE.getStudent().getStudentName(), sE.getCourse().getCourseID(), sE.getCourse().getCourseName(), sE.getSemester());
        }

        // Print the table
        table.print();
    }

    /**
     * Display a specific enrolment in table format.
     * @param enrolments: a specific enrolment.
     */
    public static void displayAnEnrolment(studentEnrolment enrolments) {
        table = new TableDisplay();

        // Setup table
        table.setHeaders("Student ID", "Student name", "Course ID", "Course name", "Semester");
        table.addRow(enrolments.getStudent().getStudentID(), enrolments.getStudent().getStudentName(), enrolments.getCourse().getCourseID(), enrolments.getCourse().getCourseName(), enrolments.getSemester());

        // Print the table
        table.print();
    }
}
