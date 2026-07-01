/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_management_system;
import java.util.*;
import java.io.*;
/**
 *
 * @author RSS - Siphelele
 */
public class Bank {
    
    
    /*
    bank class is a manager of all accounts and their 
    transaction history
    -Collection are used here to store data and information
    Why list?
    Accounts are frequently added.
    Need to loop through accounts.
    Need to search by account number.
    */
    List<Account> accounts = new ArrayList<>();
    
    List<Transaction> transactions = new ArrayList<>();
    
    Set<String> user = new HashSet<>();
    
    //Create account
    public void createAccount(Account acc){
        
        /*
        prevent duplicated accounts
        An account is an object with specific data and information
        retrieve account number from each account object that is passed client variable
        */
        for(Account client : accounts){
            /*
            compare new account number created with existing accounts
            if the condition is true then execute code
            */
            if(client.getaccountNumber().equals(acc.getaccountNumber())){
                System.out.println("ACCOUNT ALREADY EXIST.");
                //terminate 
                return;
            }
        }
        //add accounts
        accounts.add(acc);
        System.out.println("ACCOUNT SUCCESSFULLY CREATED.");
    }
    
    //view all created accounts
    public void viewAccounts(){
        
        /*
        loop over the accounts
        */
        for(Account view : accounts){
            System.out.println(view.toString());
        }
        
    }
    /*
    Deposit
    The important thing is understanding why you're looping.

    You're not looping to deposit money.

    You're looping to locate the correct Account object.

    Once you find that object, you already have access to all its data:
    Then you can perform the deposit on that specific account.
    */
    public void deposit(String accountNumber, int amount){
        /*
        loop through each account object, from each account
        object retrieve unique account number then compare  it
        from what the user enters(account number from console) then
        deposit amount that has been entered
        */
        for(Account user : accounts){
            
            if(user.getaccountNumber().equals(accountNumber)){
                user.deposit(amount);
                
                //transaction object
                Transaction transact = new Transaction(
                
                transactions.size() + 1,
                        accountNumber,
                        amount,
                        new Date(),
                        "DEPOSIT"
                        
                );
                //add the transaction history
                transactions.add(transact);
                System.out.println("DEPOSIT SUCCESSFUL");
                return;
            }
        }
        System.out.println("ACCOUNT NOT FOUND");
       
    }
    
    /*
    withdraw
    withdrawing from existing account
    */
    public void withdraw(String accountNumber, int password, int amount) throws Exception{
        
        //find the account
        for(Account user : accounts){
            /*
            compare existing account with what the user account number has
            entered
            using and operator, trying to be strict about account access
            */
            if(user.getaccountNumber().equals(accountNumber) && user.getPin() == password){
                user.withdraw(amount);
                
                
                /*
                create transaction object for withdraw
                */
                Transaction transaction = new Transaction(
                transactions.size() + 1,
                        
                        accountNumber,
                        amount,
                        new Date(),
                        "WITHDRAWAL"
                        
                );
                //add the transaction into a list
                transactions.add(transaction);
                System.out.println("WITHDRAWAL SUCCESSFULLY.");
                //stop searching once a successful withdrawal occurs.
                return;
            }
        }
        System.out.println("ACCOUNT NOT FOUND/INCORRECT PASSWORD");
        
    }
    
    /*
    Transfer money between the accounts
    */
    
    public void transaferMoney(String source, int password, String destination, int amount) throws Exception{
        
        /*
        find the source, destination amount throught the list of existing accounts
        */
        
        //accounts are objects
        Account sourceAccount = null;
        Account destinationAccount = null;
        
        /*
        using for each loop to find the existing accounts.
        Read each object at once smoothly
        */
        for (Account acc : accounts) {
        /*
            the account object will be stored on acc variable temporaly and retrive
            an account number from that acc object, then compare it to 
            source/destination or user input account from an existing account
            That account object is equal to account stored on variable acc
            */
        if (acc.getaccountNumber().equals(source)) {
            
            sourceAccount = acc;
        }

        if (acc.getaccountNumber().equals(destination)) {
            
            destinationAccount = acc;
        }
    }
    
    // Validation
    if (sourceAccount == null) {
        System.out.println("Source account not found.");
        return;
    }

    if (destinationAccount == null) {
        System.out.println("Destination account not found.");
        return;
    }

    /*
    try to make transaction from the same account 
    */
    if (source.equals(destination)) {
        System.out.println("Cannot transfer to the same account.");
        return;
    }

    /*
    incorrect source account password.
    Only the account user is authorized to make transactions
    between accounts
    */
    if (sourceAccount.getPin() != password) {
        System.out.println("Invalid password.");
        return;
    }

    // Transfer
    sourceAccount.withdraw(amount);
    destinationAccount.deposit(amount);

    // Record transaction
    Transaction transaction = new Transaction(
            transactions.size() + 1,
            source,
            amount,
            new Date(),
            "TRANSFER"
    );

    //add all the transaction history into a list
    transactions.add(transaction);

    System.out.println("Transfer successful.");
            
         
    }
    
    /*
    view all the transaction history
    */
    public void viewHistory(){
        
       for(Transaction transact : transactions){
           System.out.println(transact.toString());
       }
       
        
    }
    
    
    /*
    save records to a file from a list objects
    */
    
    public void saveRecords(){
        
        /*
        Use exception handling to handle java files
        */
        try{
            /*
            this is the core wiring: FileWriter wrapped inside the 
            BufferedWriter
            */
            BufferedWriter br = new BufferedWriter(new FileWriter("BANK TRANSACTIONS.txt"));
            
            /*
            I use  a for each loop to iterate over transaction objects
            */
            for(Transaction transact : transactions){
                
                /*
                write line from the Transaction objects stored, from List
                collection to file object
                */
                br.write(transact.getId()+", "+
                transact.getaccNumber()+", "+
                transact.getAmount()+", "+
                        transact.getType()+", "+
                        transact.getDate()
                
                
                );
                
               br.write("\n");
            }
            
            System.out.println("DATA SAVED SUCCESSFULLY.");
            /*
            data sits in the buffer
            , and without a flush/close it may never reach the file.
            */
            br.close();
            
        }catch(IOException e){
            
            System.out.println("FILE NOT FOUND");
            
            e.printStackTrace();
        }
        
        
    }
    
    
    
}
