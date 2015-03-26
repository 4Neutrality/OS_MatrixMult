/**
 * Created by Kevin on 3/25/2015.
 */
public class Matrix {
    /* 2D integer array to hold matrix representation */
    private int[][] m;
    /* Holds the number of columns */
    private int cols;
    /* Holds the number of rows */
    private int rows;

    /**
     * This is the default constructor for a Matrix object.
     *
     * @param cols the number of columns
     * @param rows the number of columns
     */
    public Matrix(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.m = new int[rows][cols];
    }

    /**
     * This is a getter method for the number of columns in the matrix object.
     *
     * @return the number of columns
     */
    public int getCols() {
        return this.cols;
    }

    /**
     * This is a getter method for the number of rows in the matrix object.
     *
     * @return the number of rows
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * This is a getter method for the 2D array, which holds the matrix integer values.
     *
     * @return the matrix 2D array
     */
    public int[][] get2DArray() {
        return this.m;
    }
}
