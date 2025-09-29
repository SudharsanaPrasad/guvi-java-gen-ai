package com.guvi;

public class ActivityB {

    /**
     *The program stores a secret in 1-100 (hardcoded for now)
     * It repeatedly guesses the secret
     * After each guess, it prints “Higher than …” or “Lower than …” by comparing the guess with
     * the secret
     * Once the secret is hit, it stops immediately
     */
    public static void main(String[] args) {
        // declare variable - stores the secret
        // loop go from 1 - 100, check if the number is the secret?

//        int randomNumber = (int) (Math.random() * 100) + 1;
//        System.out.println(randomNumber);

        /*
            // Approach 1
            store a secret
            loop
                generate a random number
                if(secret == randomNumber): DONE
                else if(secret > randomNumber): print("Higher Than..")
                else: print("Lower Than...")
         */
        /*
        int secret = 23;
        while(true) {
            // math.random -> gives us a number equal to 0.00 or a number less than < 100
            // (int) 0.1234 -> 0
            int randomNumber = (int) (Math.random() * 100) + 1;
            if(randomNumber == secret) {
                System.out.println("Secret found!");
                break;
            } else if(randomNumber > secret) {
                System.out.println("Higher Than..");
            } else {
                System.out.println("Lower Than...");
            }
        }
        */

        int secret = 23;
        for(int i = 1; i <= 100; i++) {
            if(i == secret) {
                System.out.println("Secret found!");
                break;
                //i = 200;
            } else if(i > secret) {
                System.out.println("Higher Than...");
            } else {
                System.out.println("Lower Than...");
            }
        }

    }
}
