import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Matrix class and it represents a matrix.
 *
 * @author Kevin J James, John Malott
 * @version 03.26.15
 */
public class Matrix {
    /* Holds an ArrayList of rows, which contain column values */
    private ArrayList<int[]> rowList;

    /**
     * This is the default constructor for a Matrix object.
     */
    public Matrix() {
        rowList = new ArrayList<>();
    }

    /**
     * This method adds a row to the ArrayList containing values for the Matrix object
     *
     * @param row the given String to be parsed into values
     * @param size the size of the integer array for the row
     */
    public void addRow(String row, int size) {
        int[] r = new int[size];
        Scanner s = new Scanner(row);
        for (int i = 0; i < size; i++) {
            if (s.hasNextInt()) {
                r[i] = s.nextInt();
            }
        }
        this.rowList.add(r);
    }

    /**
     * This method prints the contents a Matrix object to the screen.
     */
    public void printMatrix() {
        for (int i = 0; i < this.rowList.size(); i++) {
            for(int x : rowList.get(i)) {
                System.out.print(x + "\t");
            }
            System.out.println();
        }
    }
}
