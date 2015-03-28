import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<Drone> drones = new ArrayList<>();
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
            int rows = file.getMatrix1().getRows();
            int cols = file.getMatrix2().getCols();
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    drones.add(new Drone(r, c, file.getMatrix1().getRowArray(r), file.getMatrix2().getColArray(c), ans));
                }
            }

            /* Spawn off threads for execution */
            Thread thread;
            for (Drone d : drones) {
                thread = new Thread(d);
                thread.start();
                try {
                    /* Wait for threads to finish */
                    thread.join();
                } catch (InterruptedException ie) {
                    System.out.println("Error: Thread was interrupted.");
                    System.exit(-1);
                }
            }
            /* Print answer after threads have finished */
            for (int i = 0; i < ans.length; i++) {
                for (int k = 0; k < ans[0].length; k++) {
                    System.out.print("\t" + ans[i][k] + "\t");
                }
                System.out.println();
            }

        } catch (IOException ioe) {
            System.out.println("Error: IOException thrown.");
            System.exit(-1);
        }
    }
}
