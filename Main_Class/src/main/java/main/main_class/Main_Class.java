/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main.main_class;
import java.util.*;
/**
 *
 * @author Reverside
 */
public class Main_Class {

    
    
    public static void main(String[] args) {
        
        List<Integer> list = new ArrayList<>();
        
        //storing marks into a list
        list.add(45);
        list.add(67);
        list.add(89);
        list.add(32);
        list.add(50);
        list.add(91);
        list.add(40);
        System.out.println("original marks:"+ list);
        //using iterator to remove all marks below 50% in a safe way.
        Iterator<Integer> it = list.iterator();
        
        //using a while loop find next
        while(it.hasNext()){
            
            int number = it.next();
            if(number < 50){
                it.remove();
            }
            
        }
        //print all passing marks inside a list
        System.out.println("passing marks:");
        for(Integer i : list){
            System.out.println(i);
        }
        
        
        
    }
    
    
}
