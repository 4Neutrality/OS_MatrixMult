/**
 * This is the drone class, and it will serve as a single thread in the matrix multiplication
 * and will solve a single cell.
 *
 * @author Kevin J James
 * @version 03.25.15
 */
public class Drone implements Runnable {
    /* Holds the row values */
    int[] rows;
    /* Holds the column values */
    int[] cols;
    /* 2D Array to hold answer */
    int[][] ans;

    /**
     * This is the default constructor for a Drone object
     */
    public Drone() {
    }

    /**
     * This constructor accepts arguments, which will initialize the Drone objects field values.
     *
     * @param rows the number of given rows
     * @param cols the number of given columns
     * @param ans the 2D array in which to store the answer
     */
    public Drone(int[] rows, int[] cols, int[][] ans) {
        this.rows = rows;
        this.cols = cols;
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
        if (this.rows.length != this.cols.length) {
            System.out.println("Error: Mismatched columns and rows between matrices.");
            System.exit(-1);
        }
        /* Calculate the sum for the cell value */
        for (int i = 0; i < rows.length; i++) {
            sum += rows[i] * cols[i];
        }
    }
}
