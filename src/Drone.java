/**
 * This is the drone class, and it will serve as a single thread in the matrix multiplication
 * and will solve a single cell.
 *
 * @author Kevin J James
 * @version 03.25.15
 */
public class Drone implements Runnable {
    /* Holds the row values */
    int[] row;
    /* Holds the column values */
    int[] col;
    /* 2D Array to hold answer */
    int[][] ans;

    /**
     * This constructor accepts three arguments, which will initialize the Drone objects field values.
     *
     * @param row the number of given rows
     * @param col the number of given columns
     * @param ans the 2D array in which to store the answer
     */
    public Drone(int[] row, int[] col, int[][] ans) {
        this.row = row;
        this.col = col;
        this.ans  = ans;
    }

    /**
     * The run method is called, when a new thread is created. This method executes matrix multiplication for a single
     * cell.
     */
    @Override
    public void run() {
        /* Holds the sum for the cell */
        int sum = 0;
        /* Check if multiplication can be executed */
        if (this.row.length != this.col.length) {
            System.out.println("Error: Mismatched columns and rows between matrices.");
            System.exit(-1);
        }
        /* Calculate the sum for the cell value */
        for (int i = 0; i < row.length; i++) {
            sum += row[i] * col[i];
        }
    }
}
