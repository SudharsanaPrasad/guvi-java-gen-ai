package com.guvi.custom.problems;

import java.util.Stack;

public class InfixToPostfix {
    /**
     * Assumptions:
     *      - infix expression has spaces separating numbers, operators, & parenthesis
     *      - Support operators: +, -, *, / (precedence: * & / followed by + & -)
     *      - Operands must be positive integers
     * @param infix the infix expression as a String
     * @return return the postfix expression as a String
     * Eg:
     * precedence(token) <= precedence(stack.peek())
     * * -> 2
     * + -> 1
     * 2 <= 1 -> add it to the stack
     * input: ( 3 + 4 * 2 ) - 6 / 3
     * stack:
     * output: 3 4 2 * +
     *
     * input: 3 + 4
     * stack: +
     * output: 3 4 +
     *
     * input:
     * stack: + -- compare(new token, the top of the stack)
     * output: 3 4 *
     */
    public static String convertToPostfix(String infix) {
        // ["(3", "+", "4", ")"..]
        //
        String[] tokens = infix.split(" ");
        // tracking the operators, (, )
        Stack<String> stack = new Stack<>();
        // Tracking the output
        StringBuilder postfix = new StringBuilder();

        for(String token: tokens) {
            // is the token an operand? It must be an integer
            if(isInteger(token)) {  // "2" -> true
                // Operand: append it directly to the output
                postfix.append(token).append(" ");
            } else if(token.equals("(")) {
                // is the token "("
                    // push it to the stack
                stack.push(token);
            } else if(token.equals(")")) {
                // is the token ")"
                    // pop until we reach the matching "("
                    while(!stack.isEmpty() && !stack.peek().equals("(")) {
                        String top = stack.pop();
                        // do something with top?
                        postfix.append(top).append(" ");;
                    }

                // Fix: check if stack is NOT empty
                if(!stack.isEmpty()) {
                    // Assumption: the top operator is "("
                    // Pop it
                    stack.pop();
                }
            } else if(token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {
                // is the token an operator?

                // token being processed has a higher/equal precedence, pop
                // loop until we have eliminated tokens with lesser precedence
                // check stack size?

                //int tokenPrecedence = precedence(token);    // 1
                //int precedenceOfTopOfStack = precedence(stack.peek()); // handle an Empty.Stack.Ex
                while(!stack.isEmpty() &&
                    !stack.peek().equals("(") &&
                    // if the top has higher or equal precedence compared to token -> pop it

                    // Stack: [*] -> 2
                    // token: "-" -> 1
                    // Remove "*" & append to the output
                    precedence(token) <= precedence(stack.peek())) {
                    // remove from the top of the stack
                    String topOfStack = stack.pop();
                    // append to the output, postfix
                    postfix.append(topOfStack).append(" ");;
                }

                // push the current operator
                stack.push(token);
            }

            // ignore any other token
        }

        // Consider: stack.size(); has drawbacks
        // What'll on the stack once the loop completes?
        while(!stack.isEmpty()) {
            // pop the elements & add to the output
            postfix.append(stack.pop()).append(" ");;
        }


        return postfix.toString();
    }

    // we're mapping the token, which is an operator, to an integer
    // precedence levels:
    //      *, / -> 2
    //      +, - -> 1
    public static int precedence(String token) {
        if(token.equals("*") || token.equals("/")) {
            return 2;
        } else if(token.equals("+") || token.equals("-")) {
            return 1;
        }
        // default
        return 0;
    }

    // Check if a token is an integer
    // Input: "(" -> returns false
    // Input: "2" -> returns true
    /*
    Other ways to tackle this same problem:
        // token: "12345"
                // run a loop on this token
                // where you look at each character
                    // if char 0 && 9
                    // Character.isDigit('1')
        // regex -> token.matches("__")
     */
    public static boolean isInteger(String token) {
        // optional: null check
        try {
            // int result = Integer.parseInt(token);
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String infixSimple = "3 + 4";
        String simplePostfix = convertToPostfix(infixSimple);
        int simplePostfixEval = PostfixEvaluator.evaluatePostfix(simplePostfix);
        System.out.println("Simple infix input: " + infixSimple);
        System.out.println("Simple infix -> postfix: " + simplePostfix);
        System.out.println("Simple postfix evaluated: " + simplePostfixEval);
        System.out.println();

        String infixComplex = "( 3 + 4 * 2 ) - 6 / 3";
        String complexPostfix = convertToPostfix(infixComplex);
        int complexPostfixEval = PostfixEvaluator.evaluatePostfix(complexPostfix);
        System.out.println("Complex infix input: " + infixComplex);
        System.out.println("Complex infix -> postfix: " + complexPostfix);
        System.out.println("Complex postfix evaluated: " + complexPostfixEval);
        System.out.println();

        try {
            String buffyInfix = "(3 + 4 * 2 ) - 6 / 3";
            System.out.println("Buggy infix input: " + buffyInfix);
            String buggyPostfix = convertToPostfix(buffyInfix);
            System.out.println("Buggy infix -> postfix: " + buggyPostfix);
            int buggyPostfixEval = PostfixEvaluator.evaluatePostfix(buggyPostfix);
            System.out.println("Buggy postfix evaluated: " + buggyPostfixEval);
        } catch (Exception e) {
            System.err.println("Buggy postfix threw an exception");
            e.printStackTrace();
        }
        System.out.println();

        // Testing precedence with unexpected character
        System.out.println("Testing precedence with unexpected character '&': " + precedence("&"));
    }
}
