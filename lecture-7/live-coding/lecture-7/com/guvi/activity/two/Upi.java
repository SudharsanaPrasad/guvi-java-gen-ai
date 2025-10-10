package com.guvi.activity.two;

import com.guvi.interfaces.Payable;


/**
 * In each provider, call validate(amount) before printing or returning
 * pay(amount) returns the validated amount and prints provider line
 */
public class Upi implements Payable {
    private int balanceAmount;

    public Upi(int balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    @Override
    public String pay(int amount) {
        boolean permitted = validate(amount);
        // not permitted -> meaning false
        if(!permitted) {
            // means not permitted
            return "Insufficient Balance";
        }
        balanceAmount -= amount;
        System.out.println("UPI " + Payable.currency());
        return "Payment complete";
    }

    @Override
    public int balanceAmount() {
        return balanceAmount;
    }

    @Override
    public boolean validate(int amount) {
        return Payable.super.validate(amount);
    }
}
