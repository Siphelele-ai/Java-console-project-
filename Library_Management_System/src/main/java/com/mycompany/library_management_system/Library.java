/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;
import java.util.*;
import java.io.*;
/**
 *
 * @author RSS - Siphelele
 */
public class Library {
    
    /*
    -storing books
    -adding books
    -seaching books
    -borrowing books
    -returning books
    
    -store books using collections
    -list, set, map, queue
    */
    
    List<Book> books = new ArrayList<>();
    
    /*
    -Adding books into a list collection interface
    -list will store all the books that are added
    -Book object is passed as parameter
    */
    public void addBook(Book book){
        books.add(book);
        System.out.println("book added successfully.");
        
    }
    /*
    use for each loop to view books
    */
    public void viewBook(){
        for(Book book : books){
            System.out.println(book.getId()+ " | "+book.getTittle()+" | "+book.getAuthor());
        }
        /*
        if a book is empty then code is executed
        */
        if(books.isEmpty()){
            System.out.println("No books availables");
            return;
        }
    }
    /*
    search a book by id
    using for each loop to iterate over
    */
    public void searchBook(int id){
        for(Book book : books){
            if(book.getId() == id){
                System.out.println("book found.");
                System.out.println(book.getTittle());
                return;
            }
        }
        System.out.println("book not found.");
    }
    
    /*
    borrow a book
    */
    public void borrowBook(int id){
        
        for(Book book : books){
            if(book.getId() == id){
                
                if(book.getStatus().equals("Borrowed")){
                    System.out.println("book already borrowed");
                }else{
                    book.setStatus("Borrowed");
                    System.out.println("book borrowed");
                }
                
            }
            return;
        }
        
    }
    
    //return a book
    public void returnBook(int id){
        
        for(Book book : books){
            if(book.getId() == id){
                System.out.println("available");
                System.out.println("book returned");
            }
            return;
        }
        System.out.println("book not found.");
    }
    
    
    public void saveBook(){
        
        /*
        try-catch exception
        IO streams constructor for file creation
        */
        try{
            
            /*
            text file approach,
            The list consist of object with data inside it
            Used Buffered writer constructor to write list object 
            */
            BufferedWriter br = new BufferedWriter(new FileWriter("Library_file.txt"));
            
            //loop through each list object that has book data 
            for(Book book : books){
                
                br.write(book.getId()+", "+book.getTittle()+", "+book.getAuthor());
                
                br.newLine();
                
                
            }
            System.out.println("Books saved successfully.");
            br.close();
            
        }catch(IOException e){
            
            e.printStackTrace();
        }
        
    }
    
    /*
    here we record from a file.
    The are cetain constructors used to this 
    Load usually means: File  →  List<Book>
    for rebuilding book objects you should be thinking in terms of:
    Read one LINE
      ↓
    Extract fields
      ↓
    Create Book
      ↓
    Add to List<Book>
    */
    public void loadRecords(){
        
        try{
            /*
            FileReader constructor :Opens the file for reading text.
            BufferedReader constructor :Wraps the FileReader.
            Makes reading more efficient.
            Provides convenient methods for reading text.
            */
            BufferedReader br = new BufferedReader( new FileReader("Library_file.txt"));
            /*
            This line of code cannot be used: while((b.read()) != -1)
            Because we are reading the whole line
            because read() reads one character at a time.
            
            
            Think of looping through each line of the file text
            
            So the loading process becomes:

            Open file
            ↓
            Read first line
            ↓
            Create Book object
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ↓
            Add Book to List<Book>

            Read second line
            ↓
            Create Book object
            ↓
            Add Book to List<Book>

            
            */
            String line;
            //continue reading each line as long it is not null 
            while((line = br.readLine()) != null){
                
                /*
                file contains string data
                split each line by comma
                */
                String[] data = line.split(", ");
                
                int id = Integer.parseInt(data[0]);
                
                
                /*
                
                */
                String title = data[1];
                String author= data[2];
                String status = data[3];
                
                
                
                /*
                The constructor Book is autoamatically called and passing 
                all the required arguments inside it
                */
                Book book = new Book(id, title, author);
                book.setAuthor(status);
                
                //
                books.add(book);
                
                
            }
            br.close();
            System.out.println("records loaded successfully.");
            
            
        }catch(IOException e){
            
            e.printStackTrace(); 
            
        }
        
    }
    
    
}
