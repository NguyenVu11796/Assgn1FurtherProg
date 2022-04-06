package Assgn1FurtherProg.Assignment1.Utilities;

import Assgn1FurtherProg.Assignment1.Models.Students;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataTabularDisplay {
    //Attribute(s)
    private static TableDisplay table;

    //Methods

    /**
     * Display the search results of students in a tabular format
     * @param studentSearch list of search results of students
     */
    public static void displayStudentSearch(ArrayList<Students> studentSearch) {
     TableDisplay studentTable = new TableDisplay(); // create new instance of table attribute

     //Set up the tabular format
     studentTable.setHeaders("Student ID", "Student Name");
    }
}