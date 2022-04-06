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

        do {
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
        } while (true);
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

        do {
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
        } while (!options.equals("3"));
    }

    // 3) Course Menu
    /**
     * Display the course menu.<br>
     * Allow users to choose one operation via user input.
     */
    private void courseMenu() {
        input = new Scanner(System.in);
        String options;
        tableDisplay = new TableDisplay();

        // Setup student menu in the table
        tableDisplay.setHeaders("Input key", "Operation");
        tableDisplay.addRow("1", "View courses");
        tableDisplay.addRow("2", "View courses in semester");
        tableDisplay.addRow("3", "View courses of student in semester");
        tableDisplay.addRow("4", "Back");

        do {
            System.out.println("\nCOURSE MENU");
            tableDisplay.print();
            System.out.print("Enter an option: ");
            options = input.nextLine().trim();

            // Option cases
            switch (options) {
                case "1" -> Operations.viewCourses(studentEnrolmentManager);
                case "2" -> Operations.viewCoursesInSemester(studentEnrolmentManager);
                case "3" -> Operations.viewCoursesOfStudentsInSemester(studentEnrolmentManager);
                case "4" -> mainMenu();
                default -> System.out.println("\n/!\\ Invalid option.");
            }
        } while (!options.equals("4"));
    }

    // 4) Enrolment menu
    /**
     * Display the enrolment menu.
     * Allow users to choose one operation via users' inputs.
     */
    private void enrolmentMenu() {
        input = new Scanner(System.in);
        String options;
        tableDisplay = new TableDisplay();

        // Setup enrolment menu in table
        tableDisplay.setHeaders("Input key", "Operation");
        tableDisplay.addRow("1", "View enrolments");
        tableDisplay.addRow("2", "Enroll");
        tableDisplay.addRow("3", "Update enrolments");
        tableDisplay.addRow("4", "Back");

        // Display the enrolment menu
        do {
            System.out.println("\nENROLMENT MENU");
            tableDisplay.print();
            System.out.print("Enter an option: ");
            options = input.nextLine().trim();

            // Option cases
            switch (options) {
                case "1" -> Operations.viewEnrolments(studentEnrolmentManager);
                case "2" -> Operations.enroll(studentEnrolmentManager);
                case "3" -> updateEnrolmentsMenu();
                case "4" -> mainMenu();
                default -> System.out.println("\nYour option is invalid!");
            }
        } while (!options.equals("4"));
    }

    // 4.1) Update enrolment menu
    /**
     * After new enrollments, display the update enrolment menu.
     * Allow users to choose one operation via users' inputs.
     * This is the sub-menu of enrolment management menu.
     * To access this sub-menu, users have to enter the student ID and semester so that the operations in it will use these two properties as parameters.
     */
    private void updateEnrolmentsMenu() {
        input = new Scanner(System.in);
        String options, studentID, semester;
        tableDisplay = new TableDisplay();
        Students student;

        // Display the input Instruction
        System.out.println("\nYou can cancel this task by leaving any input field empty.");

        // Get student ID
        studentID = UserInput.getStudentID(studentEnrolmentManager);
        if (studentID.isEmpty()) {
            System.out.println("\n[X] Task cancelled.");
            enrolmentMenu();
            return;
        }

        // Get semester
        semester = UserInput.getSemesterInput();
        if (semester.isEmpty()) {
            System.out.println("\n[X] Task cancelled.");
            enrolmentMenu();
            return;
        }

        // Notify users that they are now updating enrolments of student and semester based on user input
        student = studentEnrolmentManager.getStudentByID(studentID);
        System.out.println("\n>>> You are now updating enrolments of student " + student.getStudentName() + " (" + student.getStudentID() + ") in semester " + semester + ".");
        UserInput.runNext();

        // Setup update enrolment menu in table
        tableDisplay.setHeaders("Input key", "Operation");
        tableDisplay.addRow("1", "View enrolled courses");
        tableDisplay.addRow("2", "Enroll course");
        tableDisplay.addRow("3", "Drop course");
        tableDisplay.addRow("4", "Back");

        // Display the update enrolment menu
        do {
            System.out.println("\nUPDATE ENROLMENT MENU");
            tableDisplay.print();
            System.out.print("Enter an option: ");
            options = input.nextLine().trim();

            // Option cases
            switch (options) {
                case "1" -> Operations.viewEnrolledCourses(studentID, semester, studentEnrolmentManager);
                case "2" -> Operations.enrollCourse(studentID, semester, studentEnrolmentManager);
                case "3" -> Operations.dropCourse(studentID, semester, studentEnrolmentManager);
                case "4" -> enrolmentMenu();
                default -> System.out.println("\n/Your option is invalid!");
            }
        } while (!options.equals("4"));
    }
}
