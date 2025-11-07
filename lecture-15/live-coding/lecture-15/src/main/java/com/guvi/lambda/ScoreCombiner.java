package com.guvi.lambda;

/*
Score combiner via custom functional interface
    - Define a @FunctionalInterface named IntCombiner with int apply(int a, int b).
    - You have two partial scores for a player: base value and bonus.
    - Implement a method calc(int base, int bonus, IntCombiner rule) and call it with three distinct rules:
        - sum rule: base + bonus
        - cap rule: minimum of the two: 100 OR (base + 2 * bonus); base = 10; bonus = 2;
        - penalty rule: if bonus < 0, return base + bonus*3; else base + bonus
    - Call calc method with sample bonus & base values and an instance of IntCombiner

*/

@FunctionalInterface
interface IntCombiner {
    int apply(int a, int b);
}

public class ScoreCombiner {

    public static int calc(int base, int bonus, IntCombiner rule) {
        return rule.apply(base, bonus);
    }

    public static void main(String[] args) {
        IntCombiner sumRule = (base, bonus) -> base + bonus;
        IntCombiner capRule = (base, bonus) -> Math.min(100, base + 2 * bonus);
        // Ternary operator
        // IntCombiner penaltyRule = (base, bonus) -> (bonus < 0) ? (base + bonus* 3) : (base + bonus);
        IntCombiner penaltyRule = (base, bonus) -> {
            if(bonus < 0) {
                return base + bonus * 3;
            } else {
                return base + bonus;
            }
        };

        int base = 10;
        int bonus = -10;
        int sumRes = calc(base, bonus, sumRule);
        System.out.println(sumRes);
        int capRes = calc(base, bonus, capRule);
        System.out.println(capRes);
        int penaltyRes = calc(base, bonus, penaltyRule);
        System.out.println(penaltyRes);
    }
}
