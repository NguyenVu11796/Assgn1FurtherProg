package Assgn1FurtherProg.Assignment1.Models;

public class Students implements Model{
    // Attributes
    private String studentName;
    private String studentID;
    private String studentBirthday;

    //Constructors
    public Students(String studentName, String studentID, String studentBirthday) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentBirthday = studentBirthday;
    }

    // Getters
    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentBirthday() {
        return studentBirthday;
    }

    // To String Method
    @Override
    public String toString() {
        return "Students{" +
                "studentName='" + studentName + '\'' +
                ", studentID='" + studentID + '\'' +
                ", studentBirthday='" + studentBirthday + '\'' +
                '}';
    }

    // To CSV String Method
    @Override
    public String toCSVString() {
        return studentID + "," + studentName + "," + studentBirthday + "\n";
    }
}
