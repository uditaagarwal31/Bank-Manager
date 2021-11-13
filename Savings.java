/***
 * Class to model the class Savings which extends Account 
 * @author Udita Agarwal
 * @version 0.1
 * Date of creation: September 22nd, 2021
 * Last Date Modified: September 27th, 2021
 */

public class Savings extends Account{
    // data member 
    private double interest;

    /***
	 * Default constructor
	 * No parameters
     * calls superclass 
	 * Initialises interest to 0
	 */
    public Savings(){
        super();
        interest = 0;
    }

    /***
	 * Constructor with 4 parameters
	 * @param accountNum for the account number 
     * @param owner for the account owner 
     * @param balance for the account balance 
     * @param interest for the savings interest 
     * initialises data members to values passed in parameters 
	 */
    public Savings(String accountNum, String owner, double balance, double interest){
        super(accountNum, owner, balance);
        this.interest = interest;
    }

    /***
	 * Getter for the interest 
	 * no parameters
	 * @return interest amount 
	 */
    public double getInterest(){
        return interest;
    }

     /***
	 * Setter for the interest 
	 * @param interest for the savings interest 
	 * no return value
	 */
    public void setInterest(double interest){
        this.interest = interest;
    }

    /***
	 * Method to format the string containing data members with the values to print account details
	 * no parameters 
	 * @return formatted string 
	 */
    public String toString(){
        String s = String.format("%-10s\t%-10s\t%-10.2f", "Savings", super.toString(), interest);
        return s;
    }

    /***
	 * Method to apply monthly interest in the balance 
	 * no parameters 
	 * @return balance with updated amount 
	 */
    public double applyMonthlyInterest(){
        setBalance(getBalance() + interest * getBalance());
        return getBalance();
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
        return "Savings " + super.simpleString() + interest;
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
