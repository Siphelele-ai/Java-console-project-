/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.mavenproject1;

/**
 *
 * @author Reverside
 */
public class Student implements java.io.Serializable{
    
    //student data
    private int id;
    private String name;
    private String surname;
    private String student_Number;
    
    
    //contructor initialize object state
    Student(int Id, String nam, String last_name, String stud_No){
        this.id = Id;
        this.name = nam;
        this.surname = last_name;
        this.student_Number  = stud_No;
        
    }
    
    //encapsulation 
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getstudentNumber(){
        return student_Number;
    }
    
    //data formating
    @Override
    public String toString(){
        return "[" + id +" | "+ name +" | "+ surname +" | "+ student_Number + " ]";
    }
    
}
