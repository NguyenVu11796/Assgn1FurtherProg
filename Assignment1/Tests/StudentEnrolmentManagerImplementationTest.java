package Assgn1FurtherProg.Assignment1.Tests;

import Assgn1FurtherProg.Assignment1.Interfaces.StudentEnrolmentManager;
import Assgn1FurtherProg.Assignment1.Interfaces.StudentEnrolmentManagerImplementation;
import Assgn1FurtherProg.Assignment1.Models.Courses;
import Assgn1FurtherProg.Assignment1.Models.Students;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 * Tests each method implementation in StudentEnrolmentManagerImplementation
 */
class StudentEnrolmentManagerImplementationTest {
    private final Students student = new Students("S3881101", "Nguyen Vu Le Hoang", "07/11/1996");
    private final Courses course = new Courses("COSC2440", "Further Programming", 12);
    private StudentEnrolmentManager sem;

    @BeforeEach
    void setUp() {
        sem = new StudentEnrolmentManagerImplementation();
        sem.addEnrolment(student);
        sem.addCoursebyID(course);
        sem.addEnrolment(s.getStudentID(), c.getCourseID(), "2022A");
    }

    @Test
    void addEnrolment() {
        // Enrolment with non-existing student ID or course ID should not be added
        assertFalse(sem.addEnrolment("S1234567", "COSC2440", "2022A"));
        assertEquals(sem.getEnrolments().size(), 1);

        assertFalse(sem.addEnrolment("s3881101", "ABCD1234", "2022A"));
        assertEquals(sem.getEnrolments().size(), 1);

        // Duplicated enrolment should not be added
        assertFalse(sem.addEnrolment("s3881101", "COSC2440", "2022A"));
        assertEquals(sem.getEnrolments().size(), 1);

        assertTrue(sem.addEnrolment("s3881101", "COSC2440", "2022B"));
        assertEquals(sem.getEnrolments().size(), 2);
    }

    @Test
    void deleteEnrolment() {
        // This method should return false if an enrolment to be removed does not exist even though student ID or courseID is available
        assertFalse(sem.deleteEnrolment("s3881101", "COSC2440", "2022B"));
        assertFalse(sem.deleteEnrolment("S1234567", "ABCD1234", "2022A"));

        // Otherwise, it should return true
        assertTrue(sem.deleteEnrolment("s3881101", "COSC2440", "2022A"));
        assertEquals(sem.getEnrolments().size(), 0);

        // However, if an available enrolment is already removed, it should return false when called to remove that enrolment again
        assertFalse(sem.deleteEnrolment("s3881101", "COSC2440", "2022A"));
    }

    @Test
    void getEnrolment() {
        // Based on student ID, course ID and semester, this method should return an available enrolment if found
        assertNotNull(sem.getEnrolment("s3881101", "COSC2440", "2022A"));

        // Otherwise, it should return null even though student ID or courseID is available
        assertNull(sem.getEnrolment("s3881101", "COSC2440", "2021A"));
        assertNull(sem.getEnrolment("S3881101", "ABCD1234", "2021A"));
    }

    @Test
    void getEnrolments() {
        // Check the initial size of enrolmentList
        assertEquals(sem.getEnrolments().size(), 1);

        // Upon adding or removing any enrolments, the size of enrolmentList should increase or decrease respectively
        sem.addEnrolment("s3881101", "COSC2440", "2022B");
        assertEquals(sem.getEnrolments().size(), 2);

        sem.deleteEnrolment("s3881101", "COSC2440", "2022B");
        assertEquals(sem.getEnrolments().size(), 1);
    }

    @Test
    void addStudent() {
        // This method should return false if the studentID is null or already available
        assertFalse(sem.addStudent(new Student(null, "Nguyen Vu Le Hoang", "07/11/1996"));
        assertEquals(sem.getStudents().size(), 1);

        assertFalse(sem.addStudent(new Student("s1234567", "Nguyen Vu Le Hoang", "07/11/1996")));
        assertEquals(sem.getStudents().size(), 1);

        // Otherwise, it should return true
        assertTrue(sem.addStudent(new Student("s1234567", "Nguyen Vu Le Hoang", "07/11/1996")));
        assertEquals(sem.getStudents().size(), 2);
    }

    @Test
    void getStudentByID() {
        // Based on his/her student ID, this method should return an available student if found
        assertNotNull(sem.getStudentByID("s3881101"));

        // Otherwise, this method should return null
        assertNull(sem.getStudentByID("s3881101"));
    }

    @Test
    void getStudents() {
        // Check the initial size of studentList
        assertEquals(sem.getStudents().size(), 1);

        // Upon adding any students, the size of studentList should increase.
        sem.addStudent(new Students("s1234567", "Nguyen Vu Le Hoang", "07/11/1996"));
        assertEquals(sem.getStudents().size(), 2);
    }

    @Test
    void getStudentsInCourse() {
        // This should return the list of students available in a course in a semester
        ArrayList<Student> selectedStudents = sem.getStudentsInCourse("COSC2440", "2022A");
        assertEquals(selectedStudents.size(), 1);

        // Otherwise, it should return empty list even though course ID is available
        selectedStudents = sem.getStudentsInCourse("COSC2440", "2022B");
        assertEquals(selectedStudents.size(), 0);

        selectedStudents = sem.getStudentsInCourse("ABCD1234", "2022A");
        assertEquals(selectedStudents.size(), 0);
    }

    @Test
    void addCourse() {
        // This method should return false if the courseID is null or already available
        assertFalse(sem.addCourse(new Course(null, "Further Programming", 12)));
        assertEquals(sem.getCourses().size(), 1);

        assertFalse(sem.addCourse(new Course("COSC2440", "Further Programming", 12)));
        assertEquals(sem.getCourses().size(), 1);

        // Otherwise, it should return true
        assertTrue(sem.addCourse(new Course("ABCD1234", "Welcome to RMIT", 0)));
        assertEquals(sem.getCourses().size(), 2);
    }

    @Test
    void getCourseByID() {
        // Based on course ID, this method should return an available course if found
        assertNotNull(sem.getCourseByID("COSC2440"));

        // Otherwise, this method should return null
        assertNull(sem.getStudentByID("ABCD1234"));
    }

    @Test
    void getCourses() {
        // Check the initial size of courseList
        assertEquals(sem.getCourses().size(), 1);

        // Upon adding any course, the size of studentList should increase.
        sem.addCourse(new Course("ABCD1234", "Welcome to RMIT", 0));
        assertEquals(sem.getCourses().size(), 2);
    }

    @Test
    void getCoursesInSemester() {
        // This should return the list of courses available in a semester
        ArrayList<Course> selectedCourses = sem.getCoursesInSemester("2022A");
        assertEquals(selectedCourses.size(), 1);

        // Otherwise, it should return empty list
        selectedCourses = sem.getCoursesInSemester("2022B");
        assertEquals(selectedCourses.size(), 0);
    }

    @Test
    void getCoursesOfStudentInSemester() {
        // This should return the list of courses that a student enroll in a semester
        ArrayList<Course> selectedCourses = sem.getCoursesOfStudentInSemester("S3881101", "2022A");
        assertEquals(selectedCourses.size(), 1);

        // Otherwise, it should return empty list even though the student ID is available
        selectedCourses = sem.getCoursesOfStudentInSemester("S3881101", "2022B");
        assertEquals(selectedCourses.size(), 0);

        selectedCourses = sem.getCoursesOfStudentInSemester("S3881101", "2022B");
        assertEquals(selectedCourses.size(), 0);
    }
}