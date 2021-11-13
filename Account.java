/***
 * Class to model the class Account which implements the Comparable and Closeable interfaces
 * @author Udita Agarwal
 * @version 0.1
 * Date of creation: September 22nd, 2021
 * Last Date Modified: September 27th, 2021
 */
public abstract class Account implements Comparable<Account>, Closeable{

    // data members 
    private String accountNum;
    private String owner;
    private double balance;

    /***
	 * Default constructor
	 * No parameters
	 * Initialises accountNum, owner to empty strings and balance to 0
	 */
    protected Account(){
        accountNum = "";
        owner = "";
        balance = 0;
    }

    /***
	 * Constructor with 3 parameters
	 * @param accountNum for the account number 
     * @param owner for the account owner 
     * @param balance for the account balance 
     * initialises data members to values passed in parameters 
	 */
    protected Account(String accountNum, String owner, double balance){
        this.accountNum = accountNum;
        this.owner = owner;
        this.balance = balance;
    }

    /***
	 * Getter for the account number
	 * no parameters
	 * @return the value of the account number 
	 */
    public String getAccount(){
        return accountNum;
    }

    /***
	 * Getter for the balance
	 * no parameters
	 * @return the value of the balance
	 */
    public double getBalance(){
        return balance;
    }

    /***
	 * Setter for the balance
	 * @param balance to set the balance
	 * no return value
	 */
    public void setBalance(double balance){
        this.balance = balance;
    }

    /***
	 * Getter for the owner
	 * no parameters
	 * @return the value of the owner
	 */
    public String getOwner(){
        return owner;
    }

    /***
	 * Method to withdraw a particular amount for the balance 
	 * @param amountToWithdraw for the amount the user wants to withdraw 
	 * no return value 
	 */
    public void withdrawBalance(double amountToWithdraw){
        if(getBalance() < amountToWithdraw){
            System.out.println("Withdraw failed. You do not have enough money");
        } else{
            setBalance(getBalance() - amountToWithdraw);
            System.out.println("Withdraw completed. New balance: " + getBalance());
        }
    }

    /***
	 * Method to deposit a particular amount 
	 * @param amountToDeposiit for the amount the user wants to deposit 
	 * @return updated balance
	 */
    public void depositBalance(double amountToDeposit){
        setBalance(getBalance() + amountToDeposit);
        System.out.println("Deposit completed. New balance: " + getBalance());
    }

    /***
	 * Setter for the owner
	 * @param owner to set the owner
	 * no return value
	 */
    public void setOwner(String owner){
        this.owner = owner;
    }

    /***
	 * Method to format the string containing data members with the values to print account details
	 * no parameters 
	 * @return formatted string 
	 */
    public String toString(){
        String s = String.format("%-15s\t%-25s\t%-8.2f", accountNum, owner, balance); 
        return s; 
    }

    /***
	 * Method to format the string containing data members with the values to save in the text file
	 * no parameters 
	 * @return formatted string 
	 */
    public String simpleString(){
        return accountNum + " " + owner + " " + balance + " ";
    }

    /***
	 * Method to compare balance of the accounts using interface Compareable
	 * @param a which is being compared 
	 * @return 0 if its equal, 1 if its bigger, -1 if smaller
	 */
    @Override 
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

