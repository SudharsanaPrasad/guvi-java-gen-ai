package com.guvi.activity.two;

public class Main {
    public static void main(String[] args) {
        Upi upi = new Upi(500);
        upi.pay(100);
        System.out.println(upi.balanceAmount());
    }
}
