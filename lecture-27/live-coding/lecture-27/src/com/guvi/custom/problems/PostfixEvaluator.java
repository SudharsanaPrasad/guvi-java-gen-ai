package com.guvi.custom.problems;

import com.guvi.custom.stack.Stack;

public class PostfixEvaluator {

    public static int evaluatePostfix(String expr) {
        String[] tokens = expr.split(" ");
        Stack stack = new Stack(50);
        for(String token: tokens) {
            // is the token an operator?
            //Alternatively, "+-/*".contains(token)
            // "+-/*".indexOf(token) != -1
            // token: +
            // "+-/*".indexOf("+") -> 0
            // "+-/*".indexOf("3") -> -1

            // is the token equal to +,-,/,*?

            // 3, 4, + -> is this equal to +,-,/,*?
            if(token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {
                // check if the token contains +-/*
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                // is not, the token a number
                int value = Integer.parseInt(token);
                stack.push(value);
            }
        }
        return stack.pop();
    }

    private static int applyOperator(int a, int b, String token) {
        if(token.equals("+")) {
            return a + b;
        } else if (token.equals("-")) {
            return a - b;
        } else if (token.equals("*")) {
            return a * b;
        } else {
            // division
            return a / b;
        }
    }

    public static void main(String[] args) {
        // Type of input?
        // Input: 3 + 4 -> 3 4 + -> 7
        String exp1 = "3 4 +";
        int result1 = evaluatePostfix(exp1);
        System.out.println(result1);
    }
}
