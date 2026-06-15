/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_grade_management_system;

/**
 *
 * @author RSS - Siphelele
 */
public class Student_Class {
    
    /*
    Encapsulation here it compulsory to use private access modifer to protect student 
    sensitive information 
    This data cannot be shared outside from this class
    */
    private int studentId;
    private String studentName;
    private String subject;
    private double mark;
    
    /*
    constructor: Why do we use it/
    To initialize the state of an object, this has the same name as class
    */
    Student_Class(int id, String name, String subj, double marks){
        this.studentId = id;
        this.studentName = name;
        this.subject = subj;
        this.mark = marks;
    }
    /*
    getters
    We use getters to find, or return existing class data
    Even after data has been modified, it will return modified data or value
    These method does not take parameters
    */
    public int getId(){
        return studentId;
    }
    public String getName(){
        return studentName;
    }
    public String getSubj(){
        return subject;
    }
    public double getMark(){
        return mark;
    }
    /*
    setters
    We use thise methods to change, or modify data into new existing data
    This is usefull to use for code modularity
    These methods does not return any values, but does take paramaters
    */
    public void setId(int id){
        this.studentId = id;
    }
    public void setName(String nam){
        this.studentName = nam;
    }
    public void setSubj(String subjects){
        this.subject = subjects;
    }
    public void setMark(double marks){
        this.mark = marks;
    }
    /*
    To string
    This helps to data formating, easy to be readable
    simplify the best way to read through data
    This method is an abstract method meant to be overriden to be used.
    thinking about how an object can be represented as text.
    */
    @Override
    public String toString(){
        return "id: "+studentId+" | "+"name: "+studentName+" | "+"subject: "+subject+" | "+"mark: "+mark;
    }
    
    
    
}
