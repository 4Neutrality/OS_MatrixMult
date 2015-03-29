import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//Exceptions
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.concurrent.RejectedExecutionException;

/**
 * This is the MatrixMul class and it serves as a Driver class for the program.
 *
 * @author Kevin J James, John Malott
 * @version 03.25.15
 */
public class MatrixMul {
    //Exit status for program if something bad happen
    static final int ERROR = -1;
    static final int ZERO = 0;
    static final int NO_ARGS = 0;
    static final int FIRST_ELEMENT = 0;
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
        //thread pool
        ExecutorService pool = Executors.newCachedThreadPool();
        
        //Wrong number of args
        if(args.length != NO_ARGS){
            System.out.println("Usage: MatrixMul");
            System.exit(ERROR);
        }

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

            /* Generate a drone for each cell in the answer */
            /* For example, [3x3] x [3x3] = 9 drones for each cell in the answer matrix */
            int rows = file.getMatrix1().getRows();
            int cols = file.getMatrix2().getCols();
            /* Initialize the answer array */
            ans = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    drones.add(new Drone(r, c, file.getMatrix1().getRowArray(r), file.getMatrix2().getColArray(c), ans));
                }
            }

            /* Spawn off threads for execution */
            for (Drone d : drones) {
               pool.execute(d);
            }
            pool.shutdown();

            /* Print answer after threads have finished */
            for (int i = 0; i < ans.length; i++) {
                for (int k = 0; k < ans[FIRST_ELEMENT].length; k++) {
                    System.out.print("\t" + ans[i][k] + "\t");
                }
                System.out.println();
            }




        } catch (RejectedExecutionException  ioe) {
            System.out.println("Error: Pool couldn't be executed");
            System.exit(ERROR);
        } catch (InvalidMatrixException  ioe) {
            System.out.println(ioe);
            System.exit(ERROR);
        } catch (FileNotFoundException  ioe) {
            System.out.println("Error: " + filename + " (no such file!)");
            System.exit(ERROR);
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
            System.exit(ERROR);
        }
    }
}
