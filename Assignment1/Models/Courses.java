package Assgn1FurtherProg.Assignment1.Models;

public class Courses implements Model{
    //Attributes
    private String courseName;
    private String courseID;
    private int numberOfCredits;

    //Constructors
    public Courses(String courseName, String courseID, int numberOfCredits) {
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

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    // To String method
    @Override
    public String toString() {
        return "Courses{" +
                "courseName='" + courseName + '\'' +
                ", courseID='" + courseID + '\'' +
                ", numberOfCredits='" + numberOfCredits + '\'' +
                '}';
    }

    // TO CSV STRING METHOD
    /**
     * Returns attributes of the object with commas to be appended to CSV file.
     * @return the string of values joined with comma symbol.
     */
    @Override
    public String toCSVString() {
        return courseID + "," + courseName + "," + numberOfCredits + "\n";
    }
}
