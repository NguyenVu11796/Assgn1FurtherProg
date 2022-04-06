package Assgn1FurtherProg.Assignment1.Utilities;

import java.util.*;

/**
 * Class TableDisplay is for creating the outline of the table format
 * to be implemented for displaying lists of students of courses
 */
public class TableDisplay {
    //Attributes
    private static final String horizontalLine = "-";
    private String verticalLine = "|";
    private String jointPoint = "+";
    private String[] headers;
    private List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;

    // Methods
    /**
     * Set the headers for the table.
     * @param headers the headers of the table.
     */
    public void setHeaders(String... headers) {
        this.headers = headers;
    }

    /**
     * Add the table row.
     * @param cells the cells of the table.
     */
    public void addRow(String... cells) {
        rows.add(cells);
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        verticalLine = showVerticalLines ? "|" : "";
        jointPoint = showVerticalLines ? "+" : " ";
    }

    /**
     * Print out the entire table
     */
    public void print() {
        int[] maxWidths = headers != null ? Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    /**
     * Print out the rows of the table
     * @param columnWidths: widths of the columns
     */
    private void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalLine.length() + 1, horizontalLine));
            System.out.print(jointPoint + line + (i == columnWidths.length - 1 ? jointPoint : ""));
        }
        System.out.println();
    }

    private void printRow(String[] cells, int[] maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalLine : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalLine, s, verStrTemp);
            } else {
                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalLine, s, verStrTemp);
            }
        }
        System.out.println();
    }
}
