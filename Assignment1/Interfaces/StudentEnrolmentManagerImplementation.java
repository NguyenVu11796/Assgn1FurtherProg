package Assgn1FurtherProg.Assignment1.Interfaces;

import Assgn1FurtherProg.Assignment1.Models.Students;
import Assgn1FurtherProg.Assignment1.Models.studentEnrolment;
import Assgn1FurtherProg.Assignment1.Models.Courses;
import Assgn1FurtherProg.Assignment1.Functionalities.FileHandlers;
import Assgn1FurtherProg.Assignment1.Functionalities.Validations;
import java.util.ArrayList;

public class StudentEnrolmentManagerImplementation implements StudentEnrolmentManager {
    private final ArrayList<Students> studentList = new ArrayList<>();
    private final ArrayList<Courses> courseList = new ArrayList<>();
    private final ArrayList<studentEnrolment> enrolmentList = new ArrayList<>();

    /**
     * Add a new enrolment to the enrolment list based on student ID, course ID and semester.
     * @param studentID the ID of the student to enroll.
     * @param courseID the ID of the course that student to enroll in.
     * @param semester the semester to enroll student of said course in.
     * @return false if the new enrolment already exists, true otherwise.
     */
    @Override
    public boolean addEnrolment(String studentID, String courseID, String semester) {
        Students student = getStudentByID(studentID);

        Courses course = getCourseByID(courseID);

        studentEnrolment enrolment= new studentEnrolment(student, course, semester);

        if (!Validations.enrolmentAlreadyExists(enrolment, enrolmentList)) {
            enrolmentList.add(enrolment);
            return true;
        }
        return false;
    }

    /**
     * Remove an existing enrolment from the enrolment list based on student ID, course ID and semester.
     * @param studentID the ID of the student in the enrolment that we want to remove.
     * @param courseID the ID of the course in the enrolment that we want to remove.
     * @param semester the semester in the enrolment that we want to remove.
     */
    @Override
    public void deleteEnrolment(String studentID, String courseID, String semester) {
        studentEnrolment enrolment = getEnrolmentList(studentID, courseID, semester);

        if (Validations.enrolmentAlreadyExists(enrolment, enrolmentList)) {
            enrolmentList.remove(enrolment);
        }
    }

    /**
     * Retrieve an enrolment based on student ID, course ID and semester.
     * @param studentID the ID of the student.
     * @param courseID the ID of the course.
     * @param semester the semester in the enrolment.
     * @return an enrolment object if its info exists, null otherwise.
     */
    @Override
    public studentEnrolment getEnrolmentList(String studentID, String courseID, String semester) {
        studentEnrolment enrolmentResult = null;
        for (studentEnrolment e: enrolmentList) {
            if (e.getStudent().getStudentID().equalsIgnoreCase(studentID) && e.getCourse().getCourseID().equalsIgnoreCase(courseID) && e.getSemester().equalsIgnoreCase(semester)) {
                enrolmentResult = e;
                break;
            }
        }

        return enrolmentResult;
    }

    /**
     * Retrieve all enrolments.
     * @return list of all enrolments.
     */
    public ArrayList<studentEnrolment> getEnrolments() {
        return enrolmentList;
    }

    /**
     * Retrieve a student based on student ID.
     * @param studentID the ID of the student.
     * @return a student object if its info exists, null otherwise.
     */
    @Override
    public Students getStudentByID(String studentID) {
        Students studentResult = null;
        for (Students s: studentList) {
            if (s.getStudentID().equalsIgnoreCase(studentID)) {
                studentResult = s;
                break;
            }
        }
        return studentResult;
    }

    /**
     * Retrieve all students.
     * @return list of all students.
     */
    @Override
    public ArrayList<Students> getStudents() {
        return studentList;
    }

    /**
     * Select and retrieve the students enrolling in a specific course in a specific semester.
     * @param courseID the ID of the course.
     * @param semester the semester of the enrolment.
     * @return list of students of a course in a semester.
     */
    @Override
    public ArrayList<Students> getStudentsInCourse(String courseID, String semester) {
        ArrayList<Students> selectedStudents = new ArrayList<>();
        for (studentEnrolment e: enrolmentList) {
            if (e.getCourse().getCourseID().equalsIgnoreCase(courseID) && e.getSemester().equalsIgnoreCase(semester)) {
                selectedStudents.add(e.getStudent());
            }
        }
        return selectedStudents;
    }

    /**
     * Retrieve a course based on course ID.
     * @param courseID the ID of the course that we want to retrieve.
     * @return a course object if its info exists, null otherwise.
     */
    @Override
    public Courses getCourseByID(String courseID) {
        Courses courseResult = null;
        for (Courses c: courseList) {
            if (c.getCourseID().equalsIgnoreCase(courseID)) {
                courseResult = c;
                break;
            }
        }
        return courseResult;
    }

    /**
     * Retrieve all courses.
     * @return list of all courses.
     */
    @Override
    public ArrayList<Courses> getCourses() {
        return courseList;
    }

    /**
     * Select and retrieve the courses available in a specific semester.
     * @param semester the semester of the enrolment.
     * @return list of courses offered in semester.
     */
    @Override
    public ArrayList<Courses> getCoursesInSemester(String semester) {
        ArrayList<Courses> selectedCourses = new ArrayList<>();
        for (studentEnrolment e: enrolmentList) {
            if (e.getSemester().equalsIgnoreCase(semester) && !Validations.courseAlreadyExists(e.getCourse(), selectedCourses)) {
                selectedCourses.add(e.getCourse());
            }
        }
        return selectedCourses;
    }

    /**
     * Select and retrieve the courses for a specific student in a specific semester.
     * @param studentID the ID of the student.
     * @param semester the semester of the enrolment.
     * @return list of courses for a student in a semester.
     */
    @Override
    public ArrayList<Courses> getCoursesOfStudentInSemester(String studentID, String semester) {
        ArrayList<Courses> selectedCourses = new ArrayList<>();
        for (studentEnrolment e: enrolmentList) {
            if (e.getStudent().getStudentID().equalsIgnoreCase(studentID) && e.getSemester().equalsIgnoreCase(semester)) {
                selectedCourses.add(e.getCourse());
            }
        }
        return selectedCourses;
    }

    /**
     * Get the data from csv file, convert them to model objects and then add those objects to their respective list
     */
    public void populateData() {
        ArrayList<String> dataRows = FileHandlers.readData("default.csv");

        for (String dataRow: dataRows) {
            String[] rowElements = dataRow.trim().split(",");

            // Get student, course and enrolments
            Students student = new Students(rowElements[0].trim(), rowElements[1].trim(), rowElements[2].trim());
            Courses course = new Courses(rowElements[3].trim(), rowElements[4].trim(), Integer.parseInt(rowElements[5].trim()));
            studentEnrolment enrolment = new studentEnrolment(student, course, rowElements[6].trim());

            // Check if students, courses and enrolments already exist in the lists before being added to those lists
            if (!Validations.studentAlreadyEnrolled(student, studentList)) {
                studentList.add(student);
            }

            if (!Validations.courseAlreadyExists(course,courseList)) {
                courseList.add(course);
            }

            if (!Validations.enrolmentAlreadyExists(enrolment, enrolmentList)) {
                enrolmentList.add(enrolment);
            }
        }
    }
}
