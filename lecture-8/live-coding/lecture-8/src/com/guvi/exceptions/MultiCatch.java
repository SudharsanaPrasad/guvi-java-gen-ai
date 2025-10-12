package com.guvi.exceptions;

public class MultiCatch {
    public static void main(String[] args) {
        String s = null;
        try {
            Integer.parseInt(s.trim());
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("invalid number input", e);
        }
    }
}
