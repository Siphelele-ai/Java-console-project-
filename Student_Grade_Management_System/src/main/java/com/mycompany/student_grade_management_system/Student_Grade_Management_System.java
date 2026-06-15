/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.student_grade_management_system;
import java.util.*;
/**
 *
 * @author RSS - Siphelele
 */
public class Student_Grade_Management_System {

    public static void main(String[] args) {
        
        /*
        why do we have collection class instance here?
        We to work with the data and the information that is inside
        that class. the are methods called add,remove,update and
        search
        */
        
       Collection_Class c1 = new Collection_Class();
        /*
        dashboad teacher should select any option without the program
        stopping or fail
        The program should always keep running using the teach exit the
        program then it stops running
        */
        while(true){
            
            System.out.println("1. add student: ");
            System.out.println("2. view students");
            System.out.println("3. delect student");
            System.out.println("4. search student");
            System.out.println("5. update student");
            System.out.println("6. save records");
            //ask for inputs
            System.out.println("choose option: ");
            //read input from the console
            Scanner sc = new Scanner(System.in);
            
            int input = sc.nextInt();
            //switch case for options selected by user
            switch(input){
                
                case 1:
                    try{
                        
                    
                    System.out.println("enter Id: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.println("enter student name: ");
                    String name = sc.nextLine();
                    System.out.println("enter subject: ");
                    String subject = sc.nextLine();
                    System.out.println("enter marks: ");
                    double mark = sc.nextDouble();
                    
                    /*add the students data into list
                    Undestand what do we have inside student class.
                    The parameterized constructor is present
                    */
                    c1.addStudent(new Student_Class(id, name, subject, mark));
                    
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                    
                case 2:
                    /*
                    view all students inside a list
                    */
                    c1.viewStudent();
                    break;
                    
                case 3:
                    //delete a student by id
                    System.out.println("enter student id: ");
                    int studId = sc.nextInt();
                    c1.delete(studId);
                    System.out.println("student is deleted successfully.");
                    
                    break;
                case 4:
                    /*
                    search for a student by id
                    using exception invalid id
                    */
                    try{
                    System.out.println("enter student id: ");
                    int search = sc.nextInt();
                    c1.seachStudent(search);
                    }catch(Exception e){
                        System.out.println("Invalid id");
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    /*
                    update student marks
                    */
                    System.out.println("enter id: ");
                    int id = sc.nextInt();
                    c1.upDate(id);
                    
                    break;
                    
                case 6:
                    /*
                    save records to a file
                    */
                    c1.saveRecords();
                    break;
                    
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("selection not found.");
            }
            
            
            
        }
        
        
    }
}
