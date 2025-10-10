package com.guvi.interfaces;

public interface Payable {
    String pay(int amount);
    int balanceAmount();

    // question: what are we validating?
    // do i have enough balance?
    // balance: 350
    // amount I wish spend: 500
    default boolean validate(int amount) {
        int balance = balanceAmount();
        if(amount > balance) {
            return false;
        }
        return true;
    }

    static String currency() {
        return "INR";
    }
}
