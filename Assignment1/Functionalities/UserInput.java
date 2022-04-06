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
    public static String getStudentID(StudentEnrolmentManager sem) {
        input = new Scanner(System.in);
        String studentID;

        while (true) {
            System.out.println("===========================================================================");
            System.out.print("\nEnter a student ID consisting of 's' and a series of numbers (e.g. s3881101): ");
            studentID = input.nextLine().trim();
            if (Validations.isStudentIDAvail(studentID, sem.getStudents()) || studentID.isEmpty()) {

            }
        }
    }
}
