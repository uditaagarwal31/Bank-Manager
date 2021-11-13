/***
 * Class to model the class Investment which extends Account 
 * @author Udita Agarwal
 * @version 0.1
 * Date of creation: September 22nd, 2021
 * Last Date Modified: September 27th, 2021
 */

 // to use Random class 
import java.util.Random;

public class Investment extends Account { 

    // data member 
    private String investmentType;

    /***
	 * Default constructor
	 * No parameters
     * calls superclass 
	 * Initialises investmentType to ""
	 */
    public Investment(){
        super();
        investmentType = "";
    }

    /***
	 * Constructor with 4 parameters
	 * @param accountNum for the account number 
     * @param owner for the account owner 
     * @param balance for the account balance 
     * @param investmentType for the type of investment
     * initialises data members to values passed in parameters 
	 */
    public Investment(String accountNum, String owner, double balance, String investmentType){
        super(accountNum, owner, balance);
        this.investmentType = investmentType;
    }

    /***
	 * Getter for the investment type 
	 * no parameters
	 * @return investment type
	 */
    public String getType(){
        return investmentType;
    }

    /***
	 * Setter for the investment type  
	 * @param investmentType for the investment type 
	 * no return value
	 */
    public void setType(String investmentType){
        this.investmentType = investmentType;
    }

    /***
	 * Method to format the string containing data members with the values to print account details
	 * no parameters 
	 * @return formatted string 
	 */
    public String toString(){
        String s = String.format("%-7s\t%-10s\t%-10s", "Investment", super.toString(), investmentType); 
        return s;  
    }

    /***
	 * Method to apply investment risk by generating a random number for profit/loss and random amount 5% of the balance to apply the profit/loss to
	 * no parameters 
	 * no return value
	 */
    public void applyInvestmentRisk(){
        Random random = new Random();
        double profitOrLossGenerated = random.nextDouble();
        double amtGenerated = random.nextDouble() + getBalance() * 0.05;
        if(profitOrLossGenerated >= 0.05){
            setBalance(getBalance() + amtGenerated);
            System.out.print("Profit - new balance: "); 
            System.out.printf("%.2f", getBalance());
        } else{
            setBalance(getBalance() - amtGenerated);
            System.out.print("Loss - new balance: ");
            System.out.printf("%.2f", getBalance());
        }
        System.out.println();
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

    /***
	 * Method to format the string containing data members with the values to save in the text file
	 * no parameters 
	 * @return formatted string 
	 */
    public String simpleString(){
        return "Investment " + super.simpleString() + investmentType;
    }
}
