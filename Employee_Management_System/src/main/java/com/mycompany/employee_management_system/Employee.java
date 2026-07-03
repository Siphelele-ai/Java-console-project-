/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employee_management_system;

/**
 *
 * @author RSS - Siphelele
 */
public class Employee {
    
    //data 
    private int id;
    private String name;
    private String department;
    
    //initialize object state
    Employee(int id, String nam, String depart){
        
        this.id = id;
        this.name = nam;
        this.department = depart;
        
    }
    
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDepartment(){
        return department;
    }
    
    
    
}
