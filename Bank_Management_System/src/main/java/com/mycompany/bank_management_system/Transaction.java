/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_management_system;
import java.util.*;
/**
 *
 * @author RSS - Siphelele
 */
public class Transaction {
    
    
    //transaction history, cannot be changed
    
    private int transactionId;
    private String accountNumber;
    private String type;
    private double amount;
    private Date date;
    
    //constructor
    Transaction(int id, String acc, double amount, Date d, String typ){
        
        this.transactionId = id;
        this.accountNumber = acc;
        this.amount = amount;
        this.date = d;
        this.type = typ;
    }
    
    
    
    /*
    getters
    */
    public int getId(){
       return transactionId; 
    }
    public String getaccNumber(){
        return accountNumber;
    }
    public String getType(){
        return type;
    }
    public double getAmount(){
        return amount;
    }
    public Date getDate(){
        return date;
    }
    
    @Override
    public String toString(){
        return transactionId+" | "+accountNumber+" | "+type+" | "+amount+" | "+date;
    }
    
    
}
