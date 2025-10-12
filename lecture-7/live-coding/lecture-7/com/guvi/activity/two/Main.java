package com.guvi.activity.two;

import com.guvi.interfaces.Payable;

public class Main {
    public static void main(String[] args) {

        // declare Upi
        // instantiate it
        Payable upi = new Upi(500);
        // pay method
        upi.pay(100);
        System.out.println(upi.balanceAmount());

        Upi up2 = null;

        if(up2 != null)  up2.pay(500);
    }
}
