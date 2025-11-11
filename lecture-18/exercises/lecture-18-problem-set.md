## Problem Set

### Fixed Window

#### Problem 1

Given an integer array, count how many windows of size k contain exactly two even numbers

Example:
Input: [2, 1, 4, 3, 6, 5], k = 3
Output: 3
(Windows [2,1,4], [1,4,3], [4,3,6] each have two evens.)

#### Problem 2

Given an array of daily temperatures and a window size k, print all starting indices where the average temperature exceeds a threshold t

Input: [30, 32, 35, 31, 29, 28], k = 3, t = 32
Output: [1, 2]
(Windows starting at indices 1 and 2 have averages above 32)

#### Problem 3

For each window of size k, find the difference between the maximum and minimum element.
Return the overall maximum of these differences

Example:
Input: [4, 2, 10, 3, 5], k = 3
Output: 8
(window [2,10,3] has max-min = 8)

### Variable-Sized Window

#### Problem 1

Given an array of positive integers and a target sum, find the length of the shortest subarray whose sum is at least the target

Example:
Input: [2, 3, 1, 2, 4, 3], target = 7
Output: 2 (subarray [4,3])

#### Problem 2

Given an array of positive integers and a limit value, find the length of the longest contiguous subarray whose sum is less than or equal to the limit.

Example:
Input: [1, 2, 1, 0, 1, 1, 0], limit = 4
Output: 6 (window [1,2,1,0,1,1] has sum = 6 > 4, adjust until sum ≤ 4 -- [2,1,0,1] etc.)

#### Problem 3

Longest Substring with At Most Two Distinct Characters

Example:
Input: "ccaabbb"
Output: 5
(substring "aabbb" is one of the solutions)

### StringBuilder

#### Problem 1

Write a method that compresses a string by replacing consecutive repeated characters with the character followed by its count.

Example:
Input: "aaabbccccd"
Output: "a3b2c4d1"

#### Problem 2

Given a sentence, generate an abbreviation by taking the first letter of each word and capitalizing it.

Example:
Input: "national aeronautics space administration"
Output: "NASA"


### StringBuffer

#### Problem 1

Simulate multiple threads appending parts of a sentence to a shared StringBuffer. Each thread should append one fragment (subject, verb, object). Print the final combined sentence after all threads finish.

Example Output (possible order):
Thread 1: Appending 'Java'
Thread 2: Appending 'supports'
Thread 3: Appending 'multithreading.'
Final sentence: Java supports multithreading.

#### Problem 2

Write a method that takes a sentence and reverses the order of its words using a StringBuffer. The method should be thread-safe and can be safely called from multiple threads.

Example:
Input: "Learning Java with threads"
Output: "threads with Java Learning"
