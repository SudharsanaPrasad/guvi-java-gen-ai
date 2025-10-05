package com.guvi;

/*
Fields
    vehicleNumber as text, balance as whole number not below zero
Getters
    getVehicleNumber and getBalance for read only access
Setters and actions
    setVehicleNumber trims text and rejects blank
    addMoney(amount) only if amount is positive
    payToll(fee) only if fee is positive and balance is enough
 */
public class FastTagAccount {
    private String vehicleNumber;
    private int balance;

    // parameterized constructor
    FastTagAccount(String vehicleNumber, int balance) {
        setVehicleNumber(vehicleNumber);
        this.balance = Math.max(balance, 0);
    }

    public String getVehicleNumber() { return vehicleNumber; }

    public int getBalance() { return balance; }

    public void setVehicleNumber(String vehicleNumber) {
        // isEmpty
        // "    "
        // "Soumyajit "
        // "Soumyajit"
        if(vehicleNumber != null && !vehicleNumber.isEmpty()) {
            this.vehicleNumber = vehicleNumber.trim();
        } else {
            System.out.println("Invalid vehicle number");
        }
    }

    public void addMoney(int amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Amount: " + amount + " added successfully.");
        } else {
            System.out.println("Invalid amount");
        }
    }

    /*
        public void payToll(int fee) {
            if(fee <= 0) {
                System.out.println("Invalid fee amount");
                return;
            }
            if(balance > fee) {
                balance -= fee;
                System.out.println("Toll is paid");
            } else {
                System.out.println("Insufficient balance");
            }
        }
     */

    /*
        public void payToll(int fee) {
            balance -= (fee > 0 || balance >= fee) ? fee : 0;
        }
     */

    // balance: 50
    // fee: 20
    public void payToll(int fee) {
        if(fee <= 0) {
            System.out.println("Invalid fee amount");
        } else if(balance < fee) {
            System.out.println("Insufficient balance");
        } else {
            balance -= fee;
            System.out.println("Toll is paid");
        }
    }

}
