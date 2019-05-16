/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

/**
 *
 * @author sunyan
 */
public class Address {
    
    private long userId;
    private User user;
    private String country;
    private String state;
    private String city;
    private String zip;
    private String fLine;
    private String sLine;
    private String phone;

    public Address() 
    {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getfLine() {
        return fLine;
    }

    public void setfLine(String fLine) {
        this.fLine = fLine;
    }

    public String getsLine() {
        return sLine;
    }

    public void setsLine(String sLine) {
        this.sLine = sLine;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
