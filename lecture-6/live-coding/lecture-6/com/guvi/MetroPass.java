package com.guvi;

class MetroTemplate {

}

public class MetroPass {
    // instance variables/fields
    public String ownerName;
    public int balance;

    // default constructor
    public MetroPass() {
        ownerName = "";
        balance = 0;
    }

    // parameterized constructor - parameters: String newOwnerName, int newBalance
    public MetroPass(String ownerName, int newBalance) {
        // "       " -> ""
        // if/else
        this.ownerName = (ownerName == null) ? "" : ownerName.trim();
        if (newBalance < 0) newBalance = 0;
        balance = newBalance;
    }

    // actions/verbs - methods
    public boolean addMoney(int amount) {
        if (amount <= 0) return false;
        // balance = balance + amount;
        this.balance += amount;
        return true;
    }

    public boolean rideOnce(int fare) {
        this.addMoney(500);
        if (fare <= 0 || fare > balance) return false;
        // balance = balance - fare;
        balance -= fare;
        return true;
    }
}