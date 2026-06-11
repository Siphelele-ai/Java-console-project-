/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;

/**
 *
 * @author RSS - Siphelele
 */
public class Book {
    
    //encapsulation
    private int bookId;
    private String title;
    private String author;
    private String status;
    
    //constructor
    Book(int id, String titles, String author){
        this.bookId = id;
        this.title = titles;
        this.author = author;
        this.status = "available";
    }
    //getters
    public int getId(){
        return bookId;
    }
    public String getAuthor(){
        return author;
    }
    public String getTittle(){
        return title;
    }
    public String getStatus(){
        return status;
    }
    
    //setters
    public void setId(int id){
        this.bookId = id;
    }
    public void setAuthor(String auth){
        this.author = auth;
    }
    public void setTitle(String titl){
        this.title = titl;
    }
    public void setStatus(String state){
        this.status = state;
    }
    
}
