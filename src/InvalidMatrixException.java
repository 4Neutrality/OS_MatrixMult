import java.io.IOException;
/**
 * Throws exceptions to any invalid format of a Matrix file.
 * Format:
 *   Integer(s)
 *   *
 *   Integer(s)
 *
 * Two matrices must be divide by a *. The * must be on a 
 * line by itself. Any rule applying to Matrix Multiplication also applies.
 *
 * @author Kevin J James, John Malott
 * @version 03.27.15
 */
public class InvalidMatrixException extends IOException{
   public InvalidMatrixException(String message){
       super(message);
   }
} 
