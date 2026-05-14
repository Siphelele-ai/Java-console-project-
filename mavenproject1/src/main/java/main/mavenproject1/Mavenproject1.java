/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main.mavenproject1;
//import modules
import java.io.*;
import java.util.*;
/**
 *
 * @author Reverside
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        
        //sacnner for user inputs
        Scanner sc = new Scanner(System.in);
        //list object to add students
        //creates an empty list of students
        List<Student> list = new ArrayList<>();
        
        //while loop to repeat the land-in page
        while(true){
            
            System.out.println("1. Add students.");
            System.out.println("2. view all students.");
            System.out.println("3. remove student.");
            System.out.println("4. search student by student number.");
            System.out.println("5. prevents duplicated student numbers.");
            System.out.println("6. Save students to file.");
            System.out.println("7. Export students to a file.");
            
            //read user input
            int Option = sc.nextInt();
            
            //switch case
            switch(Option){
                
                //add a student data
                case 1:
                    try{
                    System.out.println("enter id: {e.g 1, 2, 3...}");
                    int stud_Id = sc.nextInt();
                    System.out.println("enter name:");
                    String stud_Name = sc.next();
                    System.out.println("enter last name:");
                    String stud_Surname = sc.next();
                    System.out.println("enter student number:");
                    String stud_Number = sc.next();
                    
                    //add object inputs into student class object
                    Student stud = new Student(stud_Id, stud_Name, stud_Surname, stud_Number);
                    
                    //adding student class object into list
                    list.add(stud);
                    System.out.println("Student data successfully stored.");
                    
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                    
                case 2:
                    /*
                    loop over the list objects using s
                    */
                    for(Student s : list){
                        System.out.println(s.getId()+" | "+s.getName()+" | "+s.getSurname()+" | "+s.getstudentNumber());
                    }
                    break;
                    
                case 3:
                    //remove student of your choice
                    System.out.println("enter student id to remove: [1, 2, 3...]");
                    int remove_id = sc.nextInt();
                    //loop over using iterattors safe ways to remove objects
                    Iterator<Student> t = list.iterator();
                    while(t.hasNext()){
                        Student s = t.next();
                        if(s.getId() == remove_id){
                            t.remove();
                            System.out.println("student removed.");
                        }
                    }
                    
                    
                    break;
                case 4:
                    
                    Iterator<Student> stud = list.iterator();
                    
                    boolean found = false;
                    //search sudent by student number
                    System.out.println("enter your student number:");
                    String stud_Number = sc.next();
                    while(stud.hasNext()){
                        Student s = stud.next();
                        if(s.getstudentNumber().equals(stud_Number)){
                            System.out.println(s.getId()+" "+s.getName()+" "+s.getSurname()+" "+s.getstudentNumber());
                        }
                    }
                    
                    break;
                    
                case 5:
                    
                    //prevent duplicates using set
                    Set<Student> set = new HashSet<>();
                    for(Student c : list){
                        if(!c.getstudentNumber().equals(set)){
                            set.add(c);
                        }
                    }
                    
                    break;
                    
                case 6:
                    /*
            save data into a file
            1. Understand Exception handling
            2. Understand File I/O streams
            3. Understand ObjectInputStream and ObjectOutputStream
            */
                    try{
                        //create object using buffer
                        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("student_data.ser"));
                        
                        System.out.println("file is created.");
                        //file object as parameter
                        ObjectOutputStream ops = new ObjectOutputStream(bos);
                        //use object outputstream to write list object
                        ops.writeObject(list);
                        System.out.println("saved successfully.");
                        bos.close();
                        ops.close();
                    }catch(IOException e){
                        System.out.println("file not found.");
                        e.printStackTrace();
                    }
                    
                case 7:
                    
                    try{
                    //binary serialized object
                    //reads bytes from the .ser file
                    //reconstructs the original object
                    ObjectInputStream ons = new ObjectInputStream(new FileInputStream("student_data.ser"));
                    
                    /*
                    1. reads serilized data from a the file
                    2. converts it back into java objects
                    3. stores the results into a list
                    4. (List<Student>) this is called casting
                    5. Read the student list object from the file and store it inside ons
                    */
                    List<Student> load = (List<Student>) ons.readObject();
                    System.out.println("reading sudent data...");
                    
                    //It loops through every student inside the loaded list.
                    for(Student student : load){
                        //Take each student from the list one-by-one.
                        System.out.println(student.getId()+" "+student.getName()+" "+student.getSurname()+" "+student.getstudentNumber());
                    }
                    
                    }catch(IOException | ClassNotFoundException k){
                        k.printStackTrace();
                    }
            
            }
            
            
        }
        
    }
}
