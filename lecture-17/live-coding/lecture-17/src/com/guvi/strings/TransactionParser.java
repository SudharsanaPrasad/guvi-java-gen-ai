package com.guvi.strings;

public class TransactionParser {
    public static void main(String[] args) {
        String msg = "TXN:9876#Success";

        int start = msg.indexOf(":") + 1;
        int end = msg.indexOf("#");
        String txnValue = msg.substring(start, end);
        String result = "Transaction ".concat(txnValue).concat(" completed");
        // result.concat(" completed");
        System.out.println(result.intern());
        // String result2 = result.intern();
    }
}
