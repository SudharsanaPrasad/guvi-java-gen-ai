package com.guvi.interfaces;

public class Main {
    public static void main(String[] args) {
        CardGateway cg1 = new CardGateway();
        cg1.pay(450);
        cg1.refund(450);

//        Payable p1 = new CardGateway();
//        p1.pay(300);
//
//        // variable is of type Refundable
//        // instantiated as a CardGateway
//        Refundable r1 = new CardGateway();
//        r1.refund(300);
    }
}
/*

Object Oriented Programming Language
- Inheritance
- Polymorphism
- Encapsulation - hiding the internal state, and optionally certain behavior, of an object
- Abstraction -
 */