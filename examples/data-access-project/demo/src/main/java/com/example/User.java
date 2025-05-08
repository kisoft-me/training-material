package com.example;

public class User {
    private int id;
    private String Username;
    private String email;

    public User (){
        this.Username = null;
        this.email= null;
    }

    public User (int id, String Username, String email){
        this.id=id;
        this.Username=Username;
        this.email=email;
    }
    
    public int getUserId(){
        return this.id;
    }
    public void setUserId(int id){
        this.id = id;
    }
    public String getUserName(){
        return this.Username;
    }
    public void setUserName (String Username){
        this.Username = Username;
    }
    public String getUserEmail(){
        return this.email;
    }
    public void setUserEmail(String email){
        this.email = email;
    }
    public String toString(){
        return "ID: " + this.id + ", User Name: " + this.Username + ", Email: " + this.email + ".";
    }
}
