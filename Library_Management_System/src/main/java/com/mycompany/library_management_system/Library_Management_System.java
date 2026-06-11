/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.library_management_system;
import java.util.*;
/**
 *
 * @author RSS - Siphelele
 */




public class Library_Management_System {

    public static void main(String[] args) {
        //read inputs
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        
        //keeps the program running
        while(true){
            
            System.out.println("1. Add a book");
            System.out.println("2. View all books");
            System.out.println("3. Search for a book");
            System.out.println("4. borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Save records to a file");
            System.out.println("7. Load records to a file");
            System.out.println("8. Exit");
            
            System.out.println("choose: ");
            int choice = sc.nextInt();
            
            switch(choice){
                
                case 1:
                    //adding a book
                    System.out.println("enter ID: ");
                    int id = sc.nextInt();
                    System.out.println("enter title: ");
                    String title = sc.nextLine();
                    System.out.println("enter author: ");
                    String author = sc.nextLine();
                    //store data into collection
                    lib.addBook(new Book(id, title, author));
                    
                    break;
                case 2:
                    //view books
                    lib.viewBook();
                    break;
                case 3:
                    //search a book
                    System.out.println("enter ID: ");
                    int id_book = sc.nextInt();
                    lib.searchBook(id_book);
                    
                    break;
                case 4:
                    //borrow a book
                    System.out.println("enter ID: ");
                    int borrow = sc.nextInt();
                    lib.borrowBook(borrow);
                    
                    break;
                case 5:
                    //return a book
                    System.out.println("enter ID: ");
                    int returning = sc.nextInt();
                    lib.returnBook(returning);
                    
                case 6:
                    //save a book to a file
                    lib.saveBook();
                    
                    break;
                case 7:
                    //load records to a file
                    /*
                    here we read the data from the file, there constructors
                    that are used.
                    */
                    lib.loadRecords();
                    break;
                        
                case 9:
                    //exit
                    System.exit(0);
                    
                    break;
                default:
                    System.out.println("unknown selection option.");
                    
                
            }
            
        }
        
        
        
    }
}
