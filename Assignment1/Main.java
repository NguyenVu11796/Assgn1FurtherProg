package Assgn1FurtherProg.Assignment1;

import Assgn1FurtherProg.Assignment1.Interfaces.StudentEnrolmentManager;
import Assgn1FurtherProg.Assignment1.Interfaces.StudentEnrolmentManagerImplementation;
import Assgn1FurtherProg.Assignment1.UserApp.UserMenu;

/**
 * Main class to run the entire application
 */
public class Main {
    public static void main(String[] args) {
        // First, populate the data from "default.csv" file
        StudentEnrolmentManager studentEnrolmentManager = new StudentEnrolmentManagerImplementation();
        studentEnrolmentManager.populateData();

        // Next, start the application
        System.out.println("\nSTUDENT ENROLMENT MANAGEMENT APPLICATION");
        UserMenu menu = new UserMenu(studentEnrolmentManager);
        menu.mainMenu();
    }
}
