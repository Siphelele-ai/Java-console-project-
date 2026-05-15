/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main.to_do_list;
import java.util.*;
/**
 *
 * @author Reverside
 */
public class To_Do_List {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        List<String> list = new ArrayList<>();
        
        while(true){
            
            System.out.println("1. add task.");
            System.out.println("2. remove task");
            System.out.println("3. display task");
            System.out.println("4. exit");
            
            //nextLine() consistently for text input with spaces.
            //next() reads only one word and leaves the newline behind.
            
            int option = sc.nextInt();
            sc.nextLine();
            
            switch(option){
                
                case 1:
                    System.out.println("Enter task:");
                    String task_name = sc.nextLine();
                    list.add(task_name);
                    
                    
                    System.out.println("Enter description:");
                    String descr = sc.nextLine();
                    list.add(descr);
                    
                    System.out.println("successfully stored.");
                    
                    
                    break;
                    
                //remove task   
                case 2:
                    
                    System.out.println("enter task to remove:");
                    String task = sc.nextLine();
                    //safety way to remove task inside a list
                    //This avoids: ConcurrentModificationException
                    //Creates an iterator object for the list.
                    //Iterator<String> → iterator for string elements
                    //it → variable holding the iterator
                    //list.iterator() → gets the iterator from the list
                    //The iterator helps: move through the list
                    //access elements one-by-one
                    //safely remove elements
                    Iterator<String> it = list.iterator();
                    
                    
                    //Loop through the list while another element exists.
                    while(it.hasNext()){
                        //hasNext() returns:
                        //true → another element exists
                        //false → end of list reached
                        
                        
                        //Gets the current element from the list and moves the iterator forward.
                        //The value is stored in variable nextTask.                      
                        String nextTask = it.next();
                        
                        //Checks whether:the user's entered task matches
                        //the current task in the list
                        if(task.equals(nextTask)){
                            
                            //Removes the current element safely from the list.
                            it.remove();
                            System.out.println("task succesfully removed.");
                        }
                        
                    }
                    
                    break;
                    
                    //review remainding tasks
                case 3:
                    
                    for(String s : list){
                        System.out.println(s);
                    }
                    break;
                    
                    //exit
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown option selected.");
                    
            }
            
        }
        
        
    }
}
