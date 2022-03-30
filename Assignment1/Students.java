package Assignment1;

public class Students {
    private String studentName;
    private String studentID;
    private String studentBirthday;

    public Students(String studentName, String studentID, String studentBirthday) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentBirthday = studentBirthday;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentBirthday() {
        return studentBirthday;
    }
}
