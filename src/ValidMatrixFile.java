import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Kevin on 3/25/2015.
 */
public class ValidMatrixFile {
    /* The name of the file on which to run tests */
    String file;

    /**
     * The default constructor for a ValidMatrixFile object
     *
     * @param filename the given filename
     */
    public ValidMatrixFile(String filename) {
        this.file = filename;
    }

    /**
     * This method checks whether the given file exists, is empty, holds relevant values, and
     * is in the appropriate format.
     *
     * @return boolean value true if valid or false if invalid
     */
    public boolean isValidFile() {
        /* BufferedReader used for reading the file */
        BufferedReader br;
        /* Scanner used for parsing each line */
        Scanner s;
        /* Holds number of elements in first matrix */
        int elements = 0;
        /* Holds the number of rows */
        int rows = 0;
        /* Flag is true when counting first matrix */
        boolean isMatrix1 = true;
        /* Flag is true when counting second matrix */
        boolean isMatrix2 = false;

        /* Test whether file exists */
        try {
            br = new BufferedReader(new FileReader(this.file));
             /* Test whether the file contains anything */
            try {
                String line = br.readLine();
                while (line != null) {
                    /* Count rows of second matrix */
                    if (isMatrix2)
                        rows++;
                    s = new Scanner(line);
                    while (s.hasNext()) {
                        /* Test whether file holds relevant values */
                        try {
                            String val = s.next();
                            if (!val.equals("*")) {
                                /* Count columns of first matrix */
                                if (isMatrix1)
                                    elements++;
                                Integer.parseInt(val);
                            } else {
                                isMatrix1 = false;
                                isMatrix2 = true;
                            }
                        } catch (NoSuchElementException e) {
                            System.out.println("Error: Invalid file, must hold integer values.");
                            return false;
                        }
                    }
                    /* Get the next line */
                    line = br.readLine();
                }
            } catch(IOException ioe) {
                System.out.println("Error: IOException thrown: file is empty.");
                return false;
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: File not found.");
            return false;
        }

        /* (# of elements in matrix1) / (# of rows in matrix2) != (# of rows in matrix2) ==> cannot multiply */
        if (elements/rows != rows) {
            System.out.println("Error: Mismatched columns and rows between matrices.");
            return false;
        }
        return true;
    }

    /**
     * This method returns the number of rows in a given matrix.
     */
    private int numRows() {
        return 0;
    }
}
