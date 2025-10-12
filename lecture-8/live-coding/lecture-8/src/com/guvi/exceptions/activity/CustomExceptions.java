package com.guvi.exceptions.activity;

public class CustomExceptions {
    static void debit(int balance, int amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("amount " + amount + " exceeds balance " + balance);
        }
    }

    // A) Input text is "29x" at gate keypad during entry. Assume input must be a number.
    public static int parseFare(String fare) {
        return Integer.parseInt(fare);
    }

    static int parsePin(String pin) {
        // regular expression -> perform a search on a sequence of characters
        // you must provide a search pattern
        if (pin == null || !pin.matches("\\d{4}")) {
            throw new InvalidPinException("PIN must be four digits 0–9");
        }
        return Integer.parseInt(pin);
    }

    public static void main(String[] args) {
        try {
            debit(500, 750);
        } catch (InsufficientBalanceException e) {
            System.out.println("A) handled checked: " + e.getMessage());
        }

        //parsePin("12a4"); // throws InvalidPinException
        parseFare("123");
        String input = "123a";
        boolean isInteger = input.matches("^\\d+$");
        System.out.println(isInteger);
        if(isInteger) parseFare(input);
    }
}