package Assgn1FurtherProg.Assignment1.UserApp;

import Assgn1FurtherProg.Assignment1.Models.Students;
import Assgn1FurtherProg.Assignment1.Interfaces.StudentEnrolmentManager;
import Assgn1FurtherProg.Assignment1.Utilities.TableDisplay;
import Assgn1FurtherProg.Assignment1.Functionalities.UserInput;
import java.util.Scanner;

/**
 * Create a Main Menu interface for Users to select and input options
 */
public class UserMenu {
    // Attributes
    private final StudentEnrolmentManager studentEnrolmentManager;
    private Scanner input;
    private TableDisplay tableDisplay;

    // Constructors
    public UserMenu(StudentEnrolmentManager studentEnrolmentManager) {
        this.studentEnrolmentManager = studentEnrolmentManager;
    }

    // Methods
    // 1) Main Menu interface
    /**
     * Display the main menu.<br>
     * Allow users choose one option via user input.
     */
    public void mainMenu() {
        input = new Scanner(System.in);
        String options;
        tableDisplay = new TableDisplay();

        // Setup main menu in the table
        tableDisplay.setHeaders("Input key", "Operation");
        tableDisplay.addRow("1", "Manage students");
        tableDisplay.addRow("2", "Manage courses");
        tableDisplay.addRow("3", "Manage students' enrolments");
        tableDisplay.addRow("4", "Exit");

        while (true) {
            System.out.println("\nMAIN MENU");
            tableDisplay.print();
            System.out.print("Enter an option: ");
            options = input.nextLine().trim();

            // Option cases
            switch (options) {
                case "1" -> studentMenu();
                case "2" -> courseMenu();
                case "3" -> enrolmentMenu();
                case "4" -> {
                    System.out.println("\nApplication exits! Have a nice day!");
                    System.exit(0);
                }
                default -> System.out.println("\nInvalid option!");
            }
        }
    }

    // 2) Student Menu
    /**
     * Displays the students Menu
     * Allow the user to choose options through user' inputs
     */
    private void studentMenu() {
        input = new Scanner(System.in);
        String options;
        tableDisplay = new TableDisplay();

        // Setup student menu in the table
        tableDisplay.setHeaders("Input key", "Operation");
        tableDisplay.addRow("1", "View students");
        tableDisplay.addRow("2", "View students in course");
        tableDisplay.addRow("3", "Return");

        while (!options.equals("3")) {
            System.out.println("\nSTUDENT MENU");
            tableDisplay.print();
            System.out.print("Enter an option: ");
            options = input.nextLine().trim();

            // Option cases
            switch (options) {
                case "1" -> Operations.viewStudents(studentEnrolmentManager);
                case "2" -> Operations.viewStudentsInCourse(studentEnrolmentManager);
                case "3" -> mainMenu();
                default -> System.out.println("\nYour option is invalid!");
            }
        }
    }
}
