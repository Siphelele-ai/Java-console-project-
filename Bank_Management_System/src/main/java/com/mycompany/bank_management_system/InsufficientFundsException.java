/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_management_system;

/**
 *
 * @author RSS - Siphelele
 */
class InsufficientFundsException extends Exception {
    
    private double balance;
    
    InsufficientFundsException(double bal){
        this.balance = bal;
    }
    
    //getter
    public double getBalance(){
        return balance;
    }
    
    
}
