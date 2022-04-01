package Assgn1FurtherProg.Assignment1.Models;

public class Courses {
    private String courseName;
    private String courseID;
    private String numberOfCredits;

    public Courses(String courseName, String courseID, String numberOfCredits) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.numberOfCredits = numberOfCredits;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getNumberOfCredits() {
        return numberOfCredits;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseName='" + courseName + '\'' +
                ", courseID='" + courseID + '\'' +
                ", numberOfCredits='" + numberOfCredits + '\'' +
                '}';
    }
}
