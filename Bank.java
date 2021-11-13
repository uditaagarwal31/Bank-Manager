import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/***
 * Class to model the class Bank which extends Account 
 * @author Udita Agarwal
 * @version 0.1
 * Date of creation: September 22nd, 2021
 * Last Date Modified: September 27th, 2021
 */
public class Bank extends Account {
    // data members 
    Account[] accounts; 
    int accountsCount;

    /***
	 * Default constructor
	 * No parameters
	 * Initialises accounts and reads the data from the file "accounts.txt"
	 */
    public Bank(){
        accounts = new Account[100];
        accountsCount = 0;
        
        File fr = new File("accounts.txt");
        try{
            int i = 0;
            Scanner readFile = new Scanner(fr);
            while(readFile.hasNext()){
                String accountType = readFile.next();
                String accountNum = readFile.next();
                String owner = readFile.next();
                double balance = readFile.nextDouble();
                
                // depending on account type, it creates accounts with relevant data 
                switch(accountType){
                    case "Investment":
                    String investmentType = readFile.next();
                    accounts[i] = new Investment(accountNum, owner, balance, investmentType);
                    break;
    
                    case "Savings":
                    double interest = readFile.nextDouble();
                    accounts[i] = new Savings(accountNum, owner, balance, interest);
                    break;
    
                    case "Checking":
                    accounts[i] = new Checkings(accountNum, owner, balance);
                    break;
                }
                i++;
                accountsCount++;
            }
            readFile.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /***
	 * Method to find an account using the account number. Throws invalid account number exception 
	 * @param accountNum for the account number 
	 * @return account index 
     * if the account is not found, it returns -9 
	 */
    public int findAccount(String accountNum) throws InvalidAccountNum{
        int accountIndex = -9;
        // verifies validity of the account 
        if(verifyAccount(accountNum)){
            for(int i = 0; i < accountsCount; i++){
                if(accounts[i].getAccount().equals(accountNum)){
                    accountIndex = i;
                }
            }
        } 
        return accountIndex;
    }

    /***
	 * Method to verify the account using the account number. The account number has to be 6 digits. Throws invalid account number exception 
	 * @param accountNum for the account number 
	 * @return boolean whether its true or not 
	 */
    public boolean verifyAccount(String accountNum) throws InvalidAccountNum{
        // uses regular expression to check if the account number has 6 digits 
        if(accountNum.matches("\\d{6}")){
            return true;
        } else{
            throw new InvalidAccountNum("Invalid account number");
        } 
    }

    /***
	 * Method to add account using information provided by user 
	 * no parameters 
	 * no return value 
	 */
    public void addAccount(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter the account type (checking/savings/investment):");
        String type = scanner.next();
        System.out.println("Enter the owner name (first and last name):");
        String name = scanner.next() + "," + scanner.next();
        System.out.println("Enter the initial balance:");
        double balance = scanner.nextDouble();
        // randomly generates 6 digit account number 
        String accountNum = String.valueOf(random.nextInt(900000) + 100000);
        // creates accounts depending on their type 
        if(type.equalsIgnoreCase("checking")){
            accounts[accountsCount++] = new Checkings(accountNum, name, balance);
        } else if(type.equalsIgnoreCase("savings")){
            System.out.println("Enter the interest:");
            double interest = scanner.nextDouble();
            accounts[accountsCount++] = new Savings(accountNum, name, balance, interest);
        } else if(type.equalsIgnoreCase("investment")){
            System.out.println("Enter the investment type:");
            String investmentType = scanner.next();
            accounts[accountsCount++] = new Investment(accountNum, name, balance, investmentType);
        }
       System.out.println("Account successfully added");
    }

    /***
	 * Method to remove account using account number. Throws invalid account number exception if the number isn't valid
	 * @param accountNum for the account number 
	 * no return value 
	 */
    public void removeAccount(String accountNum) throws InvalidAccountNum{
        // verifies account number
        if(verifyAccount(accountNum)){
            // calls findAccount to locate the index at which the account with the number exists 
            int indexToRemove = findAccount(accountNum);
            if(indexToRemove != -9){ // if the account with that index exists 
                for(int i = indexToRemove; i < accountsCount; i++){
                    accounts[i] = accounts[i + 1];
                }
                System.out.println("Account successfully removed");
                accountsCount--;
            } else{
                System.out.println("Account can't be removed. Account not found");
            }
        }
    }

    /***
	 * Method to print accounts information 
	 * no parameter 
	 * no return value 
	 */
    public void printAccounts(){
        for(int i = 0; i < accountsCount; i++){
            System.out.println(accounts[i]);
        }
    }

    /***
	 * Method to decide whether the account is closable or not. The isClosable() methods in Savings, Investment, Checkings overrides this
	 * no parameter 
	 * @return false 
	 */
    public boolean isClosable(){
        return false;
    }

    /***
	 * Method to print accounts which are closable. Calls isClosable from the Savings/Investment/Checkings method depending on the account type to check if its closable or not 
	 * no parameter 
	 * no return value 
	 */
    public void viewClosableAccounts(){
        for(int i = 0; i < accountsCount; i++){
            if(accounts[i].isClosable()){
                System.out.println(accounts[i]);
            }
        }
    }

    /***
	 * Method to sort the accounts using the sort java package
	 * no parameter 
	 * no return value 
	 */
    public void sortAccount(){
        java.util.Arrays.sort(accounts,0,accountsCount);
    }
   
    /***
	 * Method to save information of all of the accounts in a text file "accounts.txt". Prints the information using simpleString() method
	 * no parameters
     * no return value
	 */
    public void saveAccount(){
        File file = new File("accounts.txt");
        try{
            PrintWriter writeFile = new PrintWriter(file);
            for(int i = 0; i < accountsCount; i++){
                writeFile.println(accounts[i].simpleString());
            }
            writeFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot write to accounts.txt");
        }
    }    
}

