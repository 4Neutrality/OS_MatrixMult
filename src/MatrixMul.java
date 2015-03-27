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
        /* Holds the Drone object used to calculate each cell for multiplication */
        Drone drone;

        /* Get filename from stdin */
        System.out.print("Enter input filename>");
        Scanner in = new Scanner(System.in);
        String filename = "";
        if (in.hasNext())
            filename = in.next();

        try {
            /* Read in file and print matrices */
            file = new ValidMatrixFile(filename);
            file.matrix1.printMatrix();
            System.out.println("X");
            file.matrix2.printMatrix();
        } catch (IOException ioe) {
            System.out.println("Error: IOException thrown.");
            System.exit(-1);
        }

    }
}
