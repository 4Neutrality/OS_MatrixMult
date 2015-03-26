import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This is the MatrixMul class and it serves as a Driver class for the program.
 *
 * @author Kevin J James
 * @version 03.25.15
 */
public class MatrixMul {
    /**
     * This is the main method and it will perform the relevant methods associated with matrix multiplication.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Holds ValidMatrixFile object used to test for validity */
        ValidMatrixFile file;
        /* Holds the Drone object used to calculate each cell for multiplication */
        Drone drone;
        /* 2D Array to hold the first matrix */
        int[][] matrix1;
        /* 2D Array to hold the second matrix */
        int[][] matrix2;

        /* Get filename from stdin */
        System.out.print("Enter input filename>");
        Scanner in = new Scanner(System.in);
        String filename = "";
        if (in.hasNext())
            filename = in.next();

        /* Check if the file is valid */
        file = new ValidMatrixFile(filename);

        //matrix1 = file.getMatrix1();
        //matrix2 = file.getMatrix2();

        //drone = new Drone()
    }
}
