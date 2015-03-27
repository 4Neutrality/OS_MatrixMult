/**
 * This is the drone class, and it will serve as a single thread in the matrix multiplication
 * and will solve a single cell.
 *
 * @author Kevin J James, John Malott
 * @version 03.25.15
 */
public class Drone implements Runnable {
    /* Holds the row number */
    private int rNum;
    /* Holds the column number */
    private int cNum;
    /* Holds the row values */
    private int[] row;
    /* Holds the column values */
    private int[] col;
    /* 2D Array to hold answer */
    private int[][] ans;

    /**
     * This constructor accepts three arguments, which will initialize the Drone objects field values.
     *
     * @param row the number of given rows
     * @param col the number of given columns
     * @param ans the 2D array in which to store the answer
     */
    public Drone(int rNum, int cNum, int[] row, int[] col, int[][] ans) {
        this.rNum = rNum;
        this.cNum = cNum;
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
        /* Calculate the sum for the cell value */
        for (int i = 0; i < col.length; i++) {
            sum += row[i] * col[i];
        }
        //ans[?][?] = sum
    }
}
