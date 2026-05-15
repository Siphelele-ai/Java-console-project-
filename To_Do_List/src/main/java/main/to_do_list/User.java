/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.to_do_list;
import java.util.*;
/**
 *
 * @author Reverside
 */
public class User {
   
    private String task_input;
    private String description;
    
    //constructor initialize object state
    User(String task, String descr){
        this.task_input = task;
        this.description = descr;
    }
    
    //encapsulation
    public String getTask(){
        
        return task_input;
    }
    public String getDescription(){
        
        return description;
    }
    
    
}
