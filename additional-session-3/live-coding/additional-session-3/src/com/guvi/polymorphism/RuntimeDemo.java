package com.guvi.polymorphism;

public class RuntimeDemo {

    // Interface defines the contract.
    // Different gateways can implement charge(...) in different ways.
    interface PaymentGateway {
        boolean charge(int amount);
    }

    static class RazorpayGateway implements PaymentGateway {
        @Override
        public boolean charge(int amount) {
            System.out.println("[Razorpay] Charging " + amount);
            return true;
        }
    }

    static class StripeGateway implements PaymentGateway {
        @Override
        public boolean charge(int amount) {
            System.out.println("[Stripe] Charging " + amount);
            return true;
        }
    }

    static class CheckoutService {
        private final PaymentGateway gateway;

        public CheckoutService(PaymentGateway gateway) {
            this.gateway = gateway;
        }

        public void checkout(int amount) {
            // Runtime polymorphism:
            // The actual method that runs depends on the concrete gateway object.
            gateway.charge(amount);
        }
    }

    public static void main(String[] args) {
        CheckoutService checkout1 = new CheckoutService(new RazorpayGateway());
        checkout1.checkout(500);

        CheckoutService checkout2 = new CheckoutService(new StripeGateway());
        checkout2.checkout(450);
    }
}