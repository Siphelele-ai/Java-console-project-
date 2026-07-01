/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bank_management_system;
import java.util.*;

/**
 *
 * @author RSS - Siphelele
 */

public class Bank_Management_System {

    public static void main(String[] args) {
       
        Bank b = new Bank();
        
        while(true){
            
            System.out.println("1. CREATE AN ACCOUNT ");
            System.out.println("2. VIEW ACCOUNTS " );
            System.out.println("3. DEPOSIT ");
            System.out.println("4. WITHDRAW ");
            System.out.println("5. TRANSFER AMOUNT ");
            System.out.println("6. VIEW HISTORY ");
            System.out.println("7. SAVE RECORDS");
            
            
            Scanner sc = new Scanner(System.in);
            //read input
            int options = sc.nextInt();
            
            switch(options){
                
                case 1:
                    System.out.println("ENTER ACCOUNT NUMBER");
                    String number = sc.next();
                    sc.nextLine();
                    System.out.println("ENTER ACCOUNT HOLDER: ");
                    String holder = sc.nextLine();
                    
                    System.out.println("ENTER PASSWORD FOR THIS ACCOUNT: ****");
                    int password = sc.nextInt();
                    System.out.println("ENTER BALANCE: ");
                    double balance = sc.nextDouble();
                    
                    /*
                    store user account details into collection
                    */
                    Account acc = new Account(number, holder, password, balance);
                    //create an account
                    b.createAccount(acc);
                    break;
                    
                case 2:
                    //view accounts
                    b.viewAccounts();
                    break;
                    
                    //deposit
                case 3:
                    System.out.println("ENTER ACCOUNT NUMBER: ");
                    String accountNumber = sc.next();
                    //for buffer
                    sc.nextLine();
                    System.out.println("ENTER AMOUNT TO DEPOSIT: R");
                    int amount = sc.nextInt();
                    b.deposit(accountNumber, amount);
                    
                    break;
                    
                case 4:
                    //withdraw
                    try{
                        
                        System.out.println("ENTER ACCOUNT NUMBER: ");
                        String inputAccount = sc.next();
                        //for buffer
                        sc.nextLine();
                        System.out.println("ENTER PASSWORD: ");
                        int inputPassword = sc.nextInt();
                        
                        System.out.println("ENTER AMOUNT: R");
                        int inputAmount = sc.nextInt();
                        
                        b.withdraw(inputAccount, inputPassword, inputAmount);
                        
                        
                    }catch(Exception e){
                        
                        e.printStackTrace();
                    }
                    break;
                    //transfer money
                case 5:
                    
                    try{
                        
                        System.out.println("ENTER SOURCE ACCOUNT NUMBER: ");
                        String sourceAccount = sc.next();
                        sc.nextLine();
                        System.out.println("ENTER PASSWORD: ****");
                        int sourcePassword = sc.nextInt();
                        System.out.println("ENTER DESTINATION ACCOUNT NUMBER: ");
                        String destinationAccount = sc.next();
                        System.out.println("ENTER AMOUNT TO DEPOSIT: R");
                        int sourceAmount = sc.nextInt();
                        
                        //user parameters input
                        b.transaferMoney(sourceAccount, sourcePassword, destinationAccount, sourceAmount);
                        
                    }catch(Exception e){
                        
                        e.printStackTrace();
                        
                    }
                    break;
                    
                case 6 :
                    /*
                    view the transactions
                    */
                     b.viewHistory();
                     break;
                case 7:
                    
                    /*
                    save records from a collection list to a file.txt
                    */
                    b.saveRecords();
                    
                    break;
                    
                    
                    
            }
            
        }
        
    }
}
