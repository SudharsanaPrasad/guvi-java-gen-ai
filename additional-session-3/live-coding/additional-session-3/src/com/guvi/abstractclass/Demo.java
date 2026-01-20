package com.guvi.abstractclass;

public class Demo {

    /**
     * This is a classic "template method" style setup:
     * - pay(...) defines the common workflow (validate -> authorize)
     * - subclasses provide the authorization step.
     */
    static abstract class PaymentProcessor {

        public void pay(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }

            // Shared flow: all payment processors must authorize before completing payment.
            authorize(amount);
        }

        // Subclasses decide how authorization happens (card / UPI / etc).
        protected abstract void authorize(int amount);
    }

    static class CardPaymentProcessor extends PaymentProcessor {
        @Override
        protected void authorize(int amount) {
            System.out.println("Card payment authorized for amount: " + amount);
        }
    }

    static class UpiPaymentProcessor extends PaymentProcessor {
        @Override
        protected void authorize(int amount) {
            System.out.println("UPI payment authorized for amount: " + amount);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor card = new CardPaymentProcessor();
        card.pay(500);

        PaymentProcessor upi = new UpiPaymentProcessor();
        upi.pay(450);
    }
}