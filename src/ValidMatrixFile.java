import java.io.*;
import java.util.AbstractCollection;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Kevin on 3/25/2015.
 */
public class ValidMatrixFile {
    /* The name of the file on which to run tests */
    String file;
    /* Holds the first matrix */
    Matrix matrix1;
    /* Holds the second matrix */
    Matrix matrix2;

    /**
     * The default constructor for a ValidMatrixFile object
     *
     * @param filename the given filename
     */
    public ValidMatrixFile(String filename) {
        this.file = filename;
        initMatrices();
        canBeMultiplied();
    }

    public Matrix getMatrix1() {
        BufferedReader br;
        Scanner s;
        for (int r = 0; r < matrix1.getRows(); r++) {
            for (int c = 0; c < matrix1.getCols(); c++) {
               try {
                   br = new BufferedReader(new FileReader(this.file));
                   try {
                       s = new Scanner(br.readLine());
                   } catch (IOException ioe) {
                       System.exit(-1);
                   }
               } catch (FileNotFoundException fnfe) {
                   System.exit(-1);
               }
            }
        }
        return matrix1;
    }

    public Matrix getMatrix2() {
        return matrix2;
    }

    /**
     * This method checks whether the given file exists, is empty, holds relevant values, and
     * is in the appropriate format. This method initializes the Matrix field objects.
     */
    private void initMatrices() {
        /* BufferedReader used for reading the file */
        BufferedReader br;
        /* Scanner used for parsing each line */
        Scanner s;
        /* Holds number of columns */
        int cols = 0;
        /* Holds the number of rows */
        int rows = 0;
        /* Holds an iterator */
        int i = 0;

        /* Test whether file exists */
        try {
            br = new BufferedReader(new FileReader(this.file));
            /* Test whether the file contains anything */
            try {
                String line = br.readLine();
                while (line != null) {
                    /* Get the number of cols */
                    cols = i;
                    /* Increment rows by one */
                    rows++;
                    /* Reset iterator to zero */
                    i = 0;

                    s = new Scanner(line);
                    while (s.hasNext()) {
                        /* Test whether file holds relevant values */
                        try {
                            String val = s.next();
                            if (!val.equals("*")) {
                                /* Count the elements of the matrix */
                                i++;
                                Integer.parseInt(val);
                            } else {
                                /* Subtract one from rows */
                                rows--;
                                /* Construct the first matrix */
                                matrix1 = new Matrix(rows, cols);
                                /* Reset row counter to zero */
                                rows = 0;
                            }
                        } catch (NoSuchElementException e) {
                            System.out.println("Error: Invalid file, must hold integer values.");
                            System.exit(-1);
                        }
                    }
                    /* Get the next line */
                    line = br.readLine();
                }
                /* Construct the second matrix */
                matrix2 = new Matrix(rows, cols);
            } catch(IOException ioe) {
                System.out.println("Error: IOException thrown: file is empty.");
                System.exit(-1);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: File not found.");
            System.exit(-1);
        }
    }

    /**
     * This method checks if the two matrices can be multiplied. If not, it prints an error message and exits.
     */
    private void canBeMultiplied() {
         /* (# of cols in matrix1) != (# of rows in matrix2) ==> cannot multiply */
        if (matrix1.getCols() != matrix2.getRows()) {
            System.out.println("Error: Mismatched columns and rows between matrices.");
            System.exit(-1);
        }
    }
}
