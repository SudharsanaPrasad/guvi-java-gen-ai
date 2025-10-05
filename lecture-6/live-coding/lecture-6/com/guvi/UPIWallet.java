package com.guvi;

public class UPIWallet {
    private int balance = 0;
    private String pin = "1234";

    protected int getBalance() { return balance; }

    boolean addMoney(int amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }

    boolean changePin(String oldPin, String newPin) {
        String n = (newPin == null) ? "" : newPin.trim();
        if (oldPin == null || !oldPin.equals(pin)) return false;
        if (n.length() < 4 || n.equals(pin)) return false;
        pin = n;
        return true;
    }
}
