/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sunyan
 */
public class Book {
    private long bookId;
    private String name;
    private double price;
    private String author;
    private String date;
    private String category;
    private String status;
    private String descreption;
    private User owner;
    private User cartOwner;
    private Order order;
    
    public Book() {
        
    }

    public Book(String name, double price, String author, String descreption,String category) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.descreption = descreption;
        this.category=category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getCartOwner() {
        return cartOwner;
    }

    public void setCartOwner(User cartOwner) {
        this.cartOwner = cartOwner;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    
}
