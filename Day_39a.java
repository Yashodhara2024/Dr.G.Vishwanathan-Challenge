Leetcode Problem 313 : Super Ugly Number
A super ugly number is a positive integer whose prime factors are in the array primes.
Given an integer n and an array of integers primes, return the nth super ugly number.
The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

Example 1:
Input: n = 12, primes = [2,7,13,19]
Output: 32

Code:
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] dp = new int[n];
        int[] index = new int[k];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                min = Math.min(min, (long) primes[j] * dp[index[j]]);
            }
            dp[i] = (int) min;
            for (int j = 0; j < k; j++) {
                if ((long) primes[j] * dp[index[j]] == min) {
                    index[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
