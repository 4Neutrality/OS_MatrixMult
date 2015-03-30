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
    private String file;
    /* Holds the first matrix */
    private Matrix matrix1;
    /* Holds the second matrix */
    private Matrix matrix2;

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
        runTests();
    }

    /**
     * This is a getter method for the first matrix in the valid matrix file.
     *
     * @return the first matrix
     */
    public Matrix getMatrix1() {
        return this.matrix1;
    }

    /**
     * This is a getter method for the second matrix in the valid matrix file.
     *
     * @return the second matrix
     */
    public Matrix getMatrix2() {
        return this.matrix2;
    }

    /**
     * This method attempts to read in the file, using the file field, and assigns values to the matrix fields.
     *
     * @throws InvalidMatrixException
     */
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
            counter = MatrixMul.ZERO;
            /* Parse the line into tokens */
            s = new Scanner(line);
            while (s.hasNext()) {
                token = s.next();
                hasValidValues(token);
                bAstk = checkWhichMatrix(token,counter,bAstk);
                /* Count each token */
                counter++;
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

    /**
     * This method performs tests on the given input file.
     *
     * @param before First matrix 
     * @param after Second matrix
     * @throws InvalidMatrixException
     */
    private boolean checkWhichMatrix(String token, int counter, 
                                     boolean bAstk)  throws InvalidMatrixException{

       if (token.equals("*") && counter == MatrixMul.ZERO)
           bAstk = false;
       else if(token.equals("*"))
           throw new InvalidMatrixException("'*' not on line by itself.");
       return bAstk;
    }

    /**
     * This method performs tests on the given input file.
     *
     * @throws InvalidMatrixException
     */
    private void runTests() throws InValidMatrixException{
        checkForTopBotMatrix();
        isBalanced();
    }

    /**
     * This method checks to see if the given file has an asterisk, which separates the two matrices. If no
     * such separator exists, then an error message will print and it will exit.
     *
     * @throws InvalidMatrixException
     */
    private void checkForTopBotMatrix() throws InvalidMatrixException{
        if (this.matrix1.getRows() == MatrixMul.ZERO) { //matrix1 was never assigned any values
            throw new InvalidMatrixException("First Matrix is missing.");
        }else  if (this.matrix2.getRows() == MatrixMul.ZERO) { //matrix2 was never assigned any values
            throw new InvalidMatrixException("Second Matrix or '*' is missing.");
        }
    }

    /**
     * This method checks to see if the given file holds valid matrix values, which should be integers. If not,
     * it prints an error message and exits.
     *
     * @throws InvalidMatrixException
     */
    private void hasValidValues(String token) throws InvalidMatrixException {
        try {
            if(!token.equals("*")){
              Integer.parseInt(token);
            }
        } catch (NumberFormatException nfe) {
             throw new InvalidMatrixException(token + " is not a integer value for matrix computation.");
        }

    }

    /**
     * This method checks to see is matrix1 has an equal number of columns to matrix1 number of rows. If
     * this is not the case, then multiplication cannot be executed and an error message will be printed
     * and then it will exit.
     *
     * @throws InvalidMatrixException
     */
    private void isBalanced() throws InvalidMatrixException{
        /* if (# of cols in matrix1) != (# of rows in matrix2) ==> CANNOT multiply */
        if (this.matrix1.getCols() != this.matrix2.getRows()) {
            throw new InvalidMatrixException("Mismatched columns and rows between matrices.");
        }
    }
}
