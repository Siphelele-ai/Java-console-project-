/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employee_management_system;
import java.util.*;
import java.io.*;
/**
 *
 * @author RSS - Siphelele
 */
public class Employee_Management_System {

    public static void main(String[] args) {
        
        //scanner for user input
        Scanner sc = new Scanner(System.in);
        
        List<Employee> list = new ArrayList<>();
        System.out.println("HOW MANY EMPLOYEES TO ENTER?");
        
        //read user input
        int number = sc.nextInt();
        /*
        for this program requirements we need to ask how many 
        based on the user input 
        using a for loop is the best option, we know the no employees to
        work with solution
        */
        for(int k = 1; k <= number; k++){
             
            System.out.println("EMPLOYEE : "+ k);
            System.out.println("ENTER ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            
            System.out.println("ENTER EMPLOYEE NAME: ");
            String name = sc.next();
            
            System.out.println("ENTER DEPARTMENT: ");
            String depart = sc.next();
            
            /*
            create employee object and call the constructor
            of employee class, pass argument data
            */
            Employee ep = new Employee(id, name, depart);
            /*
            store student data into list collection
            */
            list.add(ep);
            
            System.out.println("STUDENTS SUCCESSFULLY ADDED.");
            
        }
        
        
        /*
        Save the list into a file 
        */
        
        try(BufferedWriter br = new BufferedWriter(new FileWriter("employees.txt"))){
            
            //use for each loop to iterate over the list and store into file
            for(Employee worker : list){
                
                br.write(
                worker.getId()+","+
                        worker.getName()+","+
                        worker.getDepartment()
                
                );
                //read next line from the list
                br.newLine();
            }
            
            System.out.println("STUDENTS SAVED INTO A FILE.");
            
        }catch(IOException e){
            
            e.printStackTrace();
        }
        
        
        
        
    }
}
