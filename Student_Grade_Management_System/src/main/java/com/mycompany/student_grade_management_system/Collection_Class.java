/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_grade_management_system;
import java.util.*;
import java.io.*;
/**
 *
 * @author RSS - Siphelele
 */
public class Collection_Class {
    
    /*
    Inside this class, student data is:
    store using collection interface in this solution we are reqired to
    use List.
    Why ArrayList over an array? arraylist has dynamic size while a
    an array has a fixed size
    Generics provide type safety by ensuring that only Student_Class 
    objects can be stored in this list.
    Arraylist constructor creates an empty list
    */
    List<Student_Class> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    /*
    we add a student
    pass object class as a parameter inside add method
    */
    public void addStudent(Student_Class student){
        /*action parformed when this method is classed
        student is a local variable only exist only in this method
        when it stop running it not exist
        */
        list.add(student);
        System.out.println("student succefully added");
        
    }
    /*
    view a student inside list
    iterate over a list of students
    */
    public void viewStudent(){
        System.out.println("===== available candidates ====: ");
        for(Student_Class candidate : list){
            
            System.out.println(candidate);
        }
        
    }
    /*
    search student by id, best way to search for a student is by
    using iterator, moving a cursor before working with that object
    */
    public void seachStudent(int id){
        
        //traverse
        Iterator<Student_Class> search = list.iterator();
        while(search.hasNext()){
            Student_Class find = search.next();
            
            if(find.getId() == id){
                System.out.println("student found.");
                System.out.println(find.getId()+" | "+find.getName()+" | "+find.getSubj()+" | "+find.getMark());
            }
            
        }
        
    }
    
    
    
    /*
    removing a student
    The best way to remove a student is by using Iterator, it will iterate over
    each student object inside a list
    for safer removal of a student in a list. each student needs to have a 
    unique id
    */
    public void delete(int id){
        
        Iterator<Student_Class> it = list.iterator();
        while(it.hasNext()){
            // move cursor to the next student and retrieve it
            
            Student_Class value = it.next();
            //condition for comparing 
            if(value.getId() == id){
                //remove
                it.remove();
            }
            
           
        }
        
    }
    
    /*
    update objects
    each object needs to have unique id even here, this will be easy to iterate
    over a specific object using id and update it e.g 102, 103,104 if that id
    is found then return mark and now can be able to update it.
    */
    public void upDate(int id){
        
        //traverse every student object in a collection
        for(Student_Class each : list){
            
            if(each.getId() == id){ 
               
               System.out.println("student found.");
               System.out.println("current mark: "+ each.getMark());
               
               System.out.println("enter new mark:");
               int newMarks = sc.nextInt();
               each.setMark(newMarks);
               System.out.println("new mark is: "+ each.getMark());
            }
            
        }
        
    }
    /*
    show the top student in the class
    */
    public void topStudent(){
        
        for(Student_Class top : list){
            
        }
        
    }
    
    /*
    save the records from a list
    */
    public void saveRecords(){
        
        try{
           /*
            Opens the file for writting text
            creates the file if it does not exist
            allows for writting characters and strings
            */
            FileWriter fr = new FileWriter("student_record.txt");
            /*The loop is traversing
            Loop through each Student object in the collection
            */
            for(Student_Class each : list){
                /*
                what should a student look like inside a file?
                extract data using methods
                changing the destination
                Write text to file
                */
                fr.write(each.getId()+", "+
                        each.getName()+", "+
                        each.getSubj()+", "+
                        each.getMark());
                //creates a new line 
                fr.write("\n");
            }
            
            fr.close();
            System.out.println("records saved successfully.");
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    /*
    load records
    */
    public void loadRecords(){
        /*
        so here the data source is file not a list collection.
        Load from a file to list collection, using a for each, and
        iterator is not recommended
        */
        try{
            /*
            open a file
            
            */
            BufferedReader br = new BufferedReader( new FileReader("student_record.txt"));
            String line;
            
            //Read one line at a time
            while((line = br.readLine()) != null){
                /*
                Split the line
                data[0] = "101"
                data[1] = "John"
                data[2] = "Java"
                data[3] = "85.0"
                */
                String[] data = line.split(", ");
                /*
                Convert data types
                Your constructor expects: Student_Class(int, String, String, double)
                
                Integer.parseInt(data[0]): "101" → 101
                
                */
                int id = Integer.parseInt(data[0]);
                
                String name = data[1];
                
                String subject = data[2];
                /*
                Double.parseDouble(data[3]): "85.0" -> 85.0
                */
                
                double mark = Double.parseDouble(data[3]);
                
                /*create student object
                This recreates the student object in memory.
                */
                Student_Class student= new Student_Class(id, name, subject, mark);
                
                list.add(student);
                
                
            }
            
            br.close();
            System.out.println("Records loaded successfully");
            
        }catch(IOException k){
            k.printStackTrace();
        }
        
        
    }
    
    
}
