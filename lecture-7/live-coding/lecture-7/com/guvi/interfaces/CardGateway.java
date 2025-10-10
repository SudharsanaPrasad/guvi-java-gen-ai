package com.guvi.interfaces;
//implements Payable, Refundable
public class CardGateway  {

    public int pay(int amount) {
        System.out.println("Card payment for " + amount);
        return amount;
    }

    public int refund(int amount) {
        System.out.println("Payment refund " + amount);
        return amount;
    }
}
