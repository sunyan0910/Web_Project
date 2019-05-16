/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunyan
 */

public class User {
    private long userID;
    private String date;
    private String email;
    private String lName;
    private String fName;
    private String pwd;
    private List books;
    private List cart;
    private List orderHistory;
    private Address address;

    public User() {

        this.books=new ArrayList<>();
        this.cart=new ArrayList<>();
    }

    public List getCart() {
        return cart;
    }

    public void setCart(List cart) {
        this.cart = cart;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List books) {
        this.books = books;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List orderHistory) {
        this.orderHistory = orderHistory;
    }

}
