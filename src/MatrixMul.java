import java.io.IOException;
import java.util.Scanner;

/**
 * This is the MatrixMul class and it serves as a Driver class for the program.
 *
 * @author Kevin J James, John Malott
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
        /* Holds the Drone objects used to calculate each cell for multiplication */
        Drone[] drone;
        /* Holds the answer to the matrix multiplication */
        int[][] ans;

        /* Get filename from stdin */
        System.out.print("Enter input filename>");
        Scanner in = new Scanner(System.in);
        String filename = "";
        if (in.hasNext())
            filename = in.next();

        try {
            /* Read in file and print matrices */
            file = new ValidMatrixFile(filename);
            file.getMatrix1().printMatrix();
            System.out.println("X");
            file.getMatrix2().printMatrix();
            System.out.println("=");

            /* Initialize the answer array */
            ans = new int[file.getMatrix1().getRows()][file.getMatrix2().getCols()];
            /* Generate a drone for each cell in the answer */
            /* For example, [3x3] x [3x3] = 9 drones for each cell in the answer matrix */
            int numDrones = file.getMatrix1().getRows() * file.getMatrix2().getCols();
            drone = new Drone[numDrones];
            //for (int i = 0; i < numDrones; i++)
            //    drone[i] = new Drone(file.getMatrix1().getRowArray(i%3), file.getMatrix2().getColArray(i%3), ans);
            /* Spawn off threads for execution */
            //Thread thread;
            //for (Drone d : drone) {
            //    thread = new Thread(d);
            //    thread.start();
            //}

        } catch (IOException ioe) {
            System.out.println("Error: IOException thrown.");
            System.exit(-1);
        }
    }
}
