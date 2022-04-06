package Assgn1FurtherProg.Assignment1.UserApp;

import Assgn1FurtherProg.Assignment1.Models.Courses;
import Assgn1FurtherProg.Assignment1.Models.Students;
import Assgn1FurtherProg.Assignment1.Interfaces.StudentEnrolmentManager;
import Assgn1FurtherProg.Assignment1.Functionalities.FileHandlers;
import Assgn1FurtherProg.Assignment1.Utilities.DataTabularDisplay;
import Assgn1FurtherProg.Assignment1.Utilities.TableDisplay;
import Assgn1FurtherProg.Assignment1.Functionalities.UserInput;
import java.util.ArrayList;

/**
 * A class consisting of a variety of functionalities accessible to the users.
 */
public class Operations {
    // Methods
    // I. Main operations
    // 1) Manage students operations
    /**
     * Display all students. Display error messages if no student is available.
     * @param studentEnrolmentManager: the interface managing student enrolment.
     */
    static void viewStudents(StudentEnrolmentManager studentEnrolmentManager) {
        /*
        Check if the whole student list is empty or not before displaying that list in table.
        Otherwise, display error message.
         */
        if (!studentEnrolmentManager.getStudents().isEmpty()) {
            System.out.println("\nLIST OF STUDENTS");
            DataTabularDisplay.displayStudentSearch(studentEnrolmentManager.getStudents());
        }
        else {
            System.out.println("\n>>> Student list is currently empty.");
        }

        UserInput.runNext();
    }

    /**
     * Select and display the students as records based on course ID and semester which are inputted by users. If there are no records, display failure message.
     * Then, ask users if they want to save those records to CSV file.
     * @param studentEnrolmentManager: the interface managing student enrolment.
     */
    static void viewStudentsInCourse(StudentEnrolmentManager studentEnrolmentManager) {
        String courseID, semester;
        Courses course;
        ArrayList<Students> selectedStudents;

        // Display the input instruction
        System.out.println("\nNOTE: You can cancel this task by leaving any input field empty.");

        // Get course
        courseID = UserInput.getCourseID(studentEnrolmentManager);
        if (courseID.isEmpty()) {
            System.out.println("\nTask cancelled.[X]");
            UserInput.runNext();
            return;
        }

        // Get semester
        semester = UserInput.getSemesterInput();
        if (semester.isEmpty()) {
            System.out.println("\nTask cancelled.[X]");
            UserInput.runNext();
            return;
        }

        // Get the available students based on course ID and semester inputs.
        course = studentEnrolmentManager.getCourseByID(courseID);
        selectedStudents = studentEnrolmentManager.getStudentsInCourse(courseID, semester);

        if (!selectedStudents.isEmpty()) {
            System.out.println("\nLIST OF STUDENTS IN " + course.getCourseName().toUpperCase() + " (" + course.getCourseID() + ") COURSE IN SEMESTER " + semester);
            DataTabularDisplay.displayStudentSearch(selectedStudents);
        }
        else {
            System.out.println("\n>>> No students available in " + course.getCourseName() + " (" + course.getCourseID() + ") course in semester " + semester + ".");
        }

        if (UserInput.confirmToSaveRecord()) {
            String fileName = course.getCourseID().toLowerCase() + "_" + semester.toLowerCase() + ".csv";
            FileHandlers.writeInfoToFile(fileName, selectedStudents);
        }

        UserInput.runNext();
    }

    // 2) Courses operations
    /**
     * Display all courses. Display error message if no course is available.
     * @param studentEnrolmentManager: the interface managing student enrolment.
     */
    static void viewCourses(StudentEnrolmentManager studentEnrolmentManager) {
        /*
        Check if the whole course list is empty or not before displaying that list in table.
        Otherwise, display error message.
         */
        if (!studentEnrolmentManager.getCourses().isEmpty()) {
            System.out.println("\nLIST OF COURSES");
            DataTabularDisplay.displayCourseResult(studentEnrolmentManager.getCourses());
        }
        else {
            System.out.println("\n>>> Course list is currently empty.");
        }

        UserInput.runNext();
    }

    /**
     * Select and display the courses as records based on semester which is inputted by users. If there are no records, display failure message.<br>
     * Ask users if they want to save those records to CSV file or not. If yes, the process of saving records will be done.
     * @param sem the interface managing student enrolment.
     */
    static void viewCoursesInSemester(StudentEnrolmentManager sem) {
        // Display the input note
        System.out.println("\nNOTE: You can cancel this task by leaving any input field empty.");

        // Get semester
        String semester = UserInput.getSemesterInput();
        if (semester.isEmpty()) {
            System.out.println("\nTask cancelled.[X]");
            UserInput.runNext();
            return;
        }
        ArrayList<Courses> selectedCourses = sem.getCoursesInSemester(semester);

        if (!selectedCourses.isEmpty()) {
            System.out.println("\nLIST OF COURSES AVAILABLE IN SEMESTER " + semester);
            DataTabularDisplay.displayCourseResult(selectedCourses);
        }
        else {
            System.out.println("\n>>> No courses available in semester " + semester + ".");
        }

        if (UserInput.confirmToSaveRecord()) {
            String fileName = semester.toLowerCase() + ".csv";
            FileHandlers.writeInfoToFile(fileName, selectedCourses);
        }

        UserInput.runNext();
    }

    /**
     * Select and display the courses as records based on student ID and semester which are inputted by users. If there are no records, display error message.
     * Ask users if they want to save those records to CSV file.
     * @param studentEnrolmentManager: the interface managing student enrolment.
     */
    static void viewCoursesOfStudentsInSemester(StudentEnrolmentManager studentEnrolmentManager) {
        String studentID, semester;
        Students student;
        ArrayList<Courses> selectedCourses;

        // Display the input Instruction
        System.out.println("\nYou can cancel this task by leaving any input field empty.");

        // Get student ID
        studentID = UserInput.getStudentID(studentEnrolmentManager);
        if (studentID.isEmpty()) {
            System.out.println("\nTask cancelled.[X]");
            UserInput.runNext();
            return;
        }

        // Get semester
        semester = UserInput.getSemesterInput();
        if (semester.isEmpty()) {
            System.out.println("\nTask cancelled.[X]");
            UserInput.runNext();
            return;
        }

        // Get the student and his/her enrolled courses based on student ID and semester input
        student = studentEnrolmentManager.getStudentByID(studentID);
        selectedCourses = studentEnrolmentManager.getCoursesOfStudentInSemester(studentID, semester);

        if (!selectedCourses.isEmpty()) {
            System.out.println("\nLIST OF COURSES OF STUDENT " + student.getStudentName().toUpperCase() + " (" + student.getStudentID() + ") IN SEMESTER " + semester);
            DataTabularDisplay.displayCourseResult(selectedCourses);
        }
        else {
            System.out.println("\n>>> No courses available for student " + student.getStudentName() + " (" + student.getStudentID() + ") in semester " + semester + ".");
        }

        if (UserInput.confirmToSaveRecord()) {
            String fileName = student.getStudentID().toLowerCase() + "_" +semester.toLowerCase() + ".csv";
            FileHandlers.writeInfoToFile(fileName, selectedCourses);
        }

        UserInput.runNext();
    }

    // 3) Enrolments operations
    /**
     * Display all enrolments. If there are no enrolments available, display error message.
     * @param studentEnrolmentManager: the interface managing student enrolment.
     */
    static void viewEnrolments(StudentEnrolmentManager studentEnrolmentManager) {
        /*
        Check if the whole enrolment list is empty or not before displaying that list in table.
        Otherwise, display error message.
         */
        if (!studentEnrolmentManager.getEnrolments().isEmpty()) {
            // Print out the table
            System.out.println("\nLIST OF ENROLMENTS");
            DataTabularDisplay.displayEnrolmentResult(studentEnrolmentManager.getEnrolments());
        }
        else {
            System.out.println("\nStudent enrollment list is currently empty!");
        }

        UserInput.runNext();
    }

    /**
     * Asks users to enter student ID, course ID and semester to create, add and display new enrolment.
     * @param studentEnrolmentManager: the interface managing student enrolment.
     */
    static void enroll(StudentEnrolmentManager studentEnrolmentManager) {
        String studentID, courseID, semester;

        // Display the input instruction
        System.out.println("\nYou can cancel this task by leaving any input field empty.");

        // Get students
        studentID = UserInput.getStudentID(studentEnrolmentManager);
        if (studentID.isEmpty()) {
            System.out.println("\nTask cancelled.[X]");
            UserInput.runNext();
            return;
        }

        // Get course
        courseID = UserInput.getCourseID(studentEnrolmentManager);
        if (courseID.isEmpty()) {
            System.out.println("\nTask cancelled.[X]");
            UserInput.runNext();
            return;
        }

        // Get semester
        semester = UserInput.getSemesterInput();
        if (semester.isEmpty()) {
            System.out.println("\nTask cancelled.[X]");
            UserInput.runNext();
            return;
        }

        // Add and display new enrolment
        addAndDisplayNewEnrolment(studentID, courseID, semester, studentEnrolmentManager);

        UserInput.runNext();
    }

    // 3a) Update enrolments operation
    /**
     * Select and display the courses of a student in a semester
     * @param studentID the ID of the student.
     * @param semester the semester of the enrolment.
     * @param sem the interface managing student enrolment.
     */
    static void viewEnrolledCourses(String studentID, String semester, StudentEnrolmentManager sem) {
        Students student = sem.getStudentByID(studentID);
        ArrayList<Courses> selectedCourses = sem.getCoursesOfStudentInSemester(studentID, semester);

        /*
        Check if the selected course list is empty or not
        before displaying that list in table and asking users if they want to create a report file.
        Otherwise, display error message.
        */
        if (!selectedCourses.isEmpty()) {
            System.out.println("\nLIST OF COURSES OF STUDENT " + student.getStudentName().toUpperCase() + " (" + student.getStudentID() + ") IN SEMESTER " + semester);
            DataTabularDisplay.displayCourseResult(selectedCourses);
        }
        else {
            System.out.println("\n>>> No courses available for student " + student.getStudentName() + " (" + student.getStudentID() + ") in semester " + semester + ".");
        }

        UserInput.runNext();
    }

    /**
     * Asks users to enter course ID to create, add and display new enrolment.
     * @param studentID the ID of the student.
     * @param semester the semester of the enrolment.
     * @param sem the interface managing student enrolment.
     */
    static void enrollCourse(String studentID, String semester, StudentEnrolmentManager sem) {
        // Display the input note
        System.out.println("\nNOTE: You can cancel this task by leaving any input field empty.");

        // Get course
        String courseID = UserInput.getCourseID(sem);
        if (courseID.isEmpty()) {
            System.out.println("\nTask cancelled.[X]");
            UserInput.runNext();
            return;
        }

        // Add and display new enrolment
        addAndDisplayNewEnrolment(studentID, courseID, semester, sem);

        UserInput.runNext();
    }

    /**
     * Asks users to enter course ID then use this input along with studentID and semester to get enrolment info which is about to be removed.
     * If that enrolment info exists, display it. Otherwise, display failure message and terminate the operation.
     * Ask users if they want to delete that enrolment or not. If yes, the process of removing enrolment will be done.
     * @param studentID: the ID of the student.
     * @param semester: the semester of the enrolment.
     * @param studentEnrolmentManager: the interface managing student enrolment.
     */
    static void dropCourse(String studentID, String semester, StudentEnrolmentManager studentEnrolmentManager) {
        // Display the input note
        System.out.println("\nNOTE: You can cancel this task by leaving any input field empty.");

        // Get course
        String courseID = UserInput.getCourseID(studentEnrolmentManager);
        if (courseID.isEmpty()) {
            System.out.println("\nTask cancelled.[X]");
            UserInput.runNext();
            return;
        }
        Courses course = studentEnrolmentManager.getCourseByID(courseID);

        // Get student
        Students student = studentEnrolmentManager.getStudentByID(studentID);

        // Check if the enrolment to delete is available
        if (studentEnrolmentManager.getEnrolmentList(studentID, courseID, semester) != null) {
            // Display enrolment to remove
            System.out.println("\nENROLMENT TO REMOVE");
            DataTabularDisplay.displayAnEnrolment(studentEnrolmentManager.getEnrolmentList(studentID, courseID, semester));

            // Ask users if they want to remove the selected enrolment or not
            if (UserInput.confirmToRemoveEnrolment()) {
                // Continue the process
                studentEnrolmentManager.deleteEnrolment(studentID, courseID, semester);

                // Display success message
                System.out.println("\nDropped course " + course.getCourseName() + " (" + course.getCourseID() + ") successfully for student " + student.getStudentName() + " (" + student.getStudentID() + ") in semester " + semester + ".");
            }
        }
        else {
            // Display failure message
            System.out.println("\nStudent " + student.getStudentName() + " (" + student.getStudentID() + ") isn't enrolled in course " + course.getCourseName() + " (" + course.getCourseID() + "), semester " + semester + ".");
        }

        UserInput.runNext();
    }

    // II) code duplication avoidance operations
    /**
     * Add a new enrolment and display that enrollment. However, if this process failed, display failure message ONLY.
     * @param studentID: the ID of the student that we want to enroll.
     * @param courseID: the ID of the course to be enrolled in.
     * @param semester: the semester when we want to enroll student in course.
     * @param studentEnrolmentManager: interface managing student enrolment.
     */
    private static void addAndDisplayNewEnrolment (String studentID, String courseID, String semester, StudentEnrolmentManager studentEnrolmentManager) {
        // Get student
        Students student = studentEnrolmentManager.getStudentByID(studentID);

        // Get course
        Courses course = studentEnrolmentManager.getCourseByID(courseID);

        // Add a new enrolment
        if (studentEnrolmentManager.addEnrolment(studentID, courseID, semester)) {
            // Display new enrolment
            System.out.println("\nNEW ENROLMENT");
            DataTabularDisplay.displayAnEnrolment(studentEnrolmentManager.getEnrolmentList(studentID, courseID, semester));
        }
        else {
            System.out.println("\nStudent " + student.getStudentName() + " (" + student.getStudentID() + ") has already enrolled in course " + course.getCourseName() + " (" + course.getCourseID() + "), semester " + semester + ".");
        }
    }
}
