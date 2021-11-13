/***
 * Class to model the class BankManager which contains the main method 
 * @author Udita Agarwal
 * @version 0.1
 * Date of creation: September 22nd, 2021
 * Last Date Modified: September 272th, 2021
 */

 // to use the Scanner class
import java.util.Scanner;

public class BankManager {
    
    public static void main(String[] args) throws InvalidAccountNum{

        // creates an instance of Bank 
        Bank bank = new Bank();
        int userInput = 0;
        Scanner scanner = new Scanner(System.in);
        
        while(userInput != 7){
            System.out.println("Select an operation:" + "\n" + "1: Find Account" + "\n" + "2: Add Account" + "\n" + "3: Remove Account" + "\n" + "4: View Accounts" + "\n" + "5: View Closable Accounts" + "\n" + "6: Sort Account" + "\n" + "7: Exit");
            userInput = scanner.nextInt(); 
            int accountIndex = 0;

            try{
            // switch statements to execute commands according to the operation chosen by user 
                switch(userInput){
                    // Find account
                    case 1: 
                    System.out.println("Enter Account Number (6 digits):");
                    String accountNum = scanner.next();
                    // verifies bank account number
                    if(bank.verifyAccount(accountNum)){
                        accountIndex = bank.findAccount(accountNum);
                        // if the account is found, menu with more operations is printed 
                        if(accountIndex != -9){
                            findAccOperations(bank, accountIndex, scanner);
                        } else{
                            System.out.println("Account not found");
                        }
                    }
                    break;
                
                    // Add an account 
                    case 2:
                    bank.addAccount();
                    break;

                    // Remove an account 
                    case 3:
                    System.out.println("Enter account number");
                    String accNum = scanner.next();
                    bank.removeAccount(accNum);
                    break;

                    // Print accounts 
                    case 4:
                    String s = String.format("%-15s\t%-15s\t%-25s\t%-8s\t%-10s", "Type", "Account no.", "Owner", "Balance", "Interest/Investment Type");
                    System.out.println(s); 
                    bank.printAccounts();
                    break;

                    // View closable accounts 
                    case 5:
                    bank.viewClosableAccounts();
                    break;

                    // Sort accounts 
                    case 6:
                    bank.sortAccount();
                    break;

                    // Save accounts 
                    case 7:
                    bank.saveAccount();
                    break;
                }
            }
            catch(InvalidAccountNum e){
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    /***
	 * Method to print and perform operations on the account found  
	 * @param bank the instance of bank
     * @param accountIndex the index of the array containing the account
     * @param scanner to use the scanner 
	 * no return
	 */
    public static void findAccOperations(Bank bank, int accountIndex, Scanner scanner){
        int userChoice = 0;
        while(userChoice != 6){
            System.out.println("Select an operation: " + "\n" +  "1: Check Balance" + "\n" + "2: Withdraw" + "\n" + "3: Deposit" + "\n" + "4: Apply Monthly Interest" + "\n" + "5: Apply Investment Risk" + "\n" + "6: Go Back to the Main Menu");
            userChoice = scanner.nextInt();
            switch(userChoice){
                // print balance
                case 1:
                System.out.println("Balance: " + bank.accounts[accountIndex].getBalance());
                break;
                
                // withdraw the amount desired
                case 2:
                System.out.println("Enter the amount you want to withdraw:");
                bank.accounts[accountIndex].withdrawBalance(scanner.nextDouble());
                break;
                
                // deposit the amount desired
                case 3:
                System.out.println("Enter the amount you want to deposit:");
                bank.accounts[accountIndex].depositBalance(scanner.nextDouble());
                break;
                
                // apply savings interest 
                case 4:
                if(bank.accounts[accountIndex] instanceof Savings){
                    Savings a = (Savings) bank.accounts[accountIndex];
                    a.applyMonthlyInterest();
                    System.out.println("Monthly Interest has been applied. Balance: " + a.getBalance());
                    } else{
                        System.out.println("Invalid operation. Not a savings account");
                    }
                break;
                
                // apply investment risk
                case 5:
                if(bank.accounts[accountIndex] instanceof Investment){
                    Investment a = (Investment) bank.accounts[accountIndex];
                    a.applyInvestmentRisk();
                } else{
                    System.out.println("Invalid operation. Not an investment account");
                }
                break;
        
                case 6:
                break; 
            }
        }
    }
}
