package com.guvi.sliding;

/*
Problem: maxProfit (Best Time to Buy and Sell Stock)

Problem: You are given an array where the i-th element is the price of a stock on day i.
You must buy once and sell once. Find the maximum profit you can make.
Constraint: You cannot sell a stock before you buy one.
Input: [7, 1, 5, 3, 6, 4]
Output: 5
Reasoning: The best profit is from buying at 1 (day 2) and selling at 6 (day 5),
for a profit of 6 - 1 = 5.
Buying at 7 is not an option as all subsequent prices are lower.
Buying at 3 and selling at 6 gives a smaller profit of 3.
 */
public class BestTimeToBuyAndSell {

    public static int maxProfit(int[] prices) {
        // track the lowest point we've seen so far
        int minBuyPrice = Integer.MAX_VALUE;

        // we need to track max profit
        int maxProfit = 0;

        // we will iterate over the prices array
        // for each element prices[i]:
        for(int i = 0 ; i < prices.length; i++) {
            // step 1: is this the best day to buy?
            // update our lowest price seen so far
            if(prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
            } else if(prices[i] - minBuyPrice > maxProfit) {
                // step 2: is this the best day to sell?
                // if so, we'll need to update our max profit
                maxProfit = prices[i] - minBuyPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int profit = maxProfit(prices);
        System.out.println("Max profit:"  + profit);
    }
}
