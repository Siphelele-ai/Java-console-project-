/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_management_system;

/**
 *
 * @author RSS - Siphelele
 */
public class Account {
    
    /*
    This account will contain account user data and information
    */
    
    private String accountNumber;
    private String accountHolder;
    private int pin;
    private double balance;
    
    /*
    initialize object state
    each account is an object with data and information
    */
    Account(String accN, String accH, int password, double bal){
        this.accountNumber = accN;
        this.accountHolder = accH;
        this.pin = password;
        this.balance = bal;
    }
    
    /*
    deposit
    */
    public void deposit(int amount){
        
        
        if(amount > 0){
            balance += amount;
            
        }
        System.out.println("AMOUNT DEPOSITED: R"+ amount);
    }
    /*
    withdraw
    */
    public void withdraw(int amount) throws InsufficientFundsException{
        
        if(amount <= balance){
            balance -= amount;
            
        }else{
            //exceeded the current balance
            double need = amount - balance;
            System.out.println("AMOUNT NEEDED: R"+ need);
            throw new InsufficientFundsException(need);
            
        }
        
    }
    /*
    getters
    */
    public String getaccountNumber(){
        return accountNumber;
    }
    public String getaccountHolder(){
        return accountHolder;
    }
    public int getPin(){
        return pin;
    }
    public double getBalance(){
        return balance;
    }
    /*
    setters
    */
    public void setaccountNumber(String accN){
        this.accountNumber = accN;
    }
    public void setaccountHolder(String accH){
        this.accountHolder = accH;
    }
    public void setBalance(double bal){
        this.balance = bal;
    }
    
    
    
    /*
    for data formatting and redable
    */
    @Override
    public String toString(){
        return accountNumber+" | "+accountHolder+" | "+balance;
    }
    
    
    
}
