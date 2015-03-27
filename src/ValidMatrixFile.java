import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This is the ValidMatrixFile class and it represents a file with the correct contents for matrix multiplication.
 *
 * @author Kevin J James, John Malott
 * @version 03.27.15
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
    public ValidMatrixFile(String filename) throws IOException {
        this.file = filename;
        this.matrix1 = new Matrix();
        this.matrix2 = new Matrix();
        readInFile();
    }

    private void readInFile() throws IOException {
        /* BufferedReader to read line by line */
        BufferedReader br;
        /* Scanner to parse line */
        Scanner s;
        /* Strings to hold the line, and token of each line */
        String line, token;
        /* Holds the index of the column */
        int counter;

        br = new BufferedReader(new FileReader(this.file));
        /* Get the first line */
        line = br.readLine();

        /* Holds the flag determining if we're before the asterisk */
        boolean bAstk = true;
        /* Holds the flag determining whether the asterisk is passed */
        boolean pAstk = false;

        while (line != null) {
            /* Reset counter to zero */
            counter = 0;
            /* Parse the line into tokens */
            s = new Scanner(line);
            while (s.hasNext()) {
                token = s.next();
                /* Count each token */
                counter++;
                if (token.equals("*"))
                    bAstk = false;
            }
            if (bAstk) { //Construct matrix1 before asterisk
                this.matrix1.addRow(line, counter);
                line = br.readLine();
            } else if (pAstk){ //Construct matrix2 after asterisk
                this.matrix2.addRow(line, counter);
                line = br.readLine();
            } else {
                line = br.readLine();
                pAstk = true;
            }
        }
    }
}
