package com.company.users;

import java.util.Random;

public class User {
    private String user;
    private double balance;
    private String accNumber;



    public User(String user, double balance) {
        this.user = user;
        this.balance = balance;
        Random random = new Random();
        this.accNumber = "LT" + (random.nextInt(99999 - 10000) + 10000);


    }
    public String getAccNumber() {
        return accNumber;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return
                "Vartotojas : " + user +
                ", balansas : " + balance +
                ", saskaitos numeris : " + accNumber
                ;
    }
}
