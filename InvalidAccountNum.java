/***
 * Class to model the class InvalidAccountNum which extends Exception  
 * @author Udita Agarwal
 * @version 0.1
 * Date of creation: September 22nd, 2021
 * Last Date Modified: September 27th, 2021
 */

public class InvalidAccountNum extends Exception {
    
    /***
	 * Default constructor
	 * No parameters
     * calls superclass 
	 */
    public InvalidAccountNum(){
        super();
    }

    /***
	 * Constructor with 1 parameter
	 * @param message for the error message 
     * calls superclass and passes message in 
	 */
    public InvalidAccountNum(String message){
        super(message);
    }
}
