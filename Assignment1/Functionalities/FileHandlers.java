package Assgn1FurtherProg.Assignment1.Functionalities;

import Assgn1FurtherProg.Assignment1.Models.Model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * This class extracts, reads, and handle any operation from csv files
 */
public class FileHandlers {
    //Methods

    /**
     * Get the data from a file
     *
     * @param file the name of the file where the data is located
     * @return the list of strings containing the data rows in a file
     */
    public static ArrayList<String> readData(String file) {
        ArrayList<String> dataRows = new ArrayList<>();

        try {
            File dataFile = new File(file);
            Scanner fileReader = new Scanner(dataFile);

            //after first try, check condition if rows are empty
            while (fileReader.hasNextLine()) {
                String dataRow = fileReader.nextLine();
                // check the current row is empty
                if (dataRow.isEmpty()) {
                    continue; // continue to next row if this one is empty
                }
                dataRows.add(dataRow);
            }

            fileReader.close();
        }
        //catch exception if no file is located.
        catch (FileNotFoundException e) {
            System.out.println("\n/!\\ File not found. Please try again.");
            e.printStackTrace(); //print out the throwable along with the details
        }

        return dataRows;
    }

    /**
     * Print a list of records as data and export to a file
     *
     * @param fileName the file to write the data
     * @param records  the list of objects to be printed to the file
     */
    public static void writeInfoToFile(String fileName, ArrayList<? extends Model> records) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (Model m : records) {
                fileWriter.write(m.toCSVString());
            }
            fileWriter.close();
            System.out.println("\n>>> Records have been successfully printed in '" + fileName + "' file.");
        } catch (IOException e) {
            System.out.println("\n/!\\ An error occurred while saving report to CSV file. Please try again.");
            e.printStackTrace();
        }
    }
}
