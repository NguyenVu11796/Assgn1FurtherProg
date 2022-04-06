package Assgn1FurtherProg.Assignment1.Functionalities;

import java.util.Scanner;
import Assgn1FurtherProg.Assignment1.Interfaces.StudentEnrolmentManager;

/**
 * This class gives the users different options for inputs and data location
 */
public class UserInput {
    //Attributes
    private static Scanner input;

    //Methods

    /**
     * Get a student ID input from the user.
     *
     * @param studentEnrolmentManager: an interface managing student enrolment
     * @return an existing student ID or an empty string if student is not in list
     */
    public static String getStudentID(StudentEnrolmentManager studentEnrolmentManager) {
        input = new Scanner(System.in);
        String studentID;

        while (true) {
            System.out.println("===========================================================================");
            System.out.print("\nEnter a student ID consisting of 's' and a series of numbers (e.g. s3881101): ");
            studentID = input.nextLine().trim();
            if (Validations.isStudentIDAvail(studentID, studentEnrolmentManager.getStudents()) || studentID.isEmpty()) {
                break;
            } else {
                System.out.println("\nThe student ID " + studentID + " does not exist!");
            }
        }
        return studentID;
    }

    /**
     * Get a course ID input by the user.
     * @param studentEnrolmentManager: an interface managing student enrolment.
     * @return an existing course ID or an empty string.
     */
    public static String getCourseID(StudentEnrolmentManager studentEnrolmentManager) {
        input = new Scanner(System.in);
        String courseID;

        while (true) {
            System.out.println("===============================================");
            System.out.print("\nEnter a course ID (e.g. ABC1234 or abcd1234): ");
            courseID = input.nextLine().trim();
            if (Validations.isCourseIDAvail(courseID, studentEnrolmentManager.getCourses()) || courseID.isEmpty()) {
                break;
            } else {
                System.out.println("\n/!\\ Course ID " + courseID + " does not exist.");
            }
        }

        return courseID;
    }

    /**
     * Get a semester input by the user
     * @return an uppercase semester string with correct format or empty string.
     */
    public static String getSemesterInput() {
        input = new Scanner(System.in);
        String semester;

        while (true) {
            System.out.println("========================================");
            System.out.print("\nEnter a semester (e.g. 2020A, or 2021b): ");
            semester = input.nextLine().trim();
            if (semester.matches("^\\d{4,}[A-Ca-c]$") || semester.isEmpty()) {
                break;
            }
            else {
                System.out.println("\nInvalid semester format: Semester must include a year and one letter between A and C (case insensitive)!");
            }
        }

        return semester.toUpperCase();
    }

    /**
     * Check if users want to save the record to CSV file.
     * @return true if user enter "y" or "Y" (case-insensitive), and false otherwise.
     */
    public static boolean confirmToSaveRecord() {
        input = new Scanner(System.in);

        System.out.println("===============================================================");
        System.out.print("\nDo you want to save this record to CSV file? (Press 'y'/'Y'): ");
        return input.nextLine().equalsIgnoreCase("Y");
    }

    /**
     * Check whether users want to remove an enrolment.
     * @return true if user enter "y" or "Y" (case-insensitive), and false otherwise.
     */
    public static boolean confirmToRemoveEnrolment() {
        input = new Scanner(System.in);

        System.out.println("===============================================================");
        System.out.print("\nAre you sure you want to remove this enrolment? (Y/y: yes) => ");
        return input.nextLine().equalsIgnoreCase("Y");
    }

    /**
     * Serves the function to manually continue by pressing "Enter".
     */
    public static void runNext() {
        input = new Scanner(System.in);

        System.out.print("\nPress Enter to continue.");
        input.nextLine();
    }
}
