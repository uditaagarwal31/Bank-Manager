/***
 * Class to model the class Checkings which extends Account 
 * @author Udita Agarwal
 * @version 0.1
 * Date of creation: September 22nd, 2021
 * Last Date Modified: September 27th, 2021
 */

public class Checkings extends Account{

    /***
	 * Default constructor
	 * No parameters
     * calls superclass 
	 */
    public Checkings(){
        super();
    }

    /***
	 * Constructor with 3 parameters
	 * @param accountNum for the account number 
     * @param owner for the account owner 
     * @param balance for the account balance 
     * initialises data members to values passed in parameters 
	 */
    public Checkings(String accountNum, String owner, double balance){
        super(accountNum, owner, balance);
    }

    /***
	 * Method to format the string containing data members with the values to print account details
	 * no parameters 
	 * @return formatted string 
	 */
    public String toString(){
        String s = String.format("%-7s\t%-10s", "Checkings", super.toString()); 
        return s;
    }

    /***
	 * Method which returns whether the account is closable or not using interface Closeable
	 * no parameters 
	 * @return boolean saying whether its closable or not 
	 */
    @Override
    public boolean isClosable(){
        if(getBalance() < 200){
            return true;
        }
        return false;
    }

    /***
	 * Method to format the string containing data members with the values to save in the text file
	 * no parameters 
	 * @return formatted string 
	 */
    public String simpleString(){
        return "Checking " + super.simpleString();
    }

    /***
	 * Method to compare balance of the accounts using interface Compareable
	 * @param a which is being compared 
	 * @return 0 if its equal, 1 if its bigger, -1 if smaller
	 */
    public int compareTo(Account a){
        if(this.getBalance() == a.getBalance()){
            return 0;
        } else if(this.getBalance() > a.getBalance()){
            return 1;
        } else{
            return -1;
        }
    }  
}
