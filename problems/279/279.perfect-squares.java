/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        /*
         * given n, return the least number of perfect square numbers that sum to n.
         * perfect squares -> 1,4,9,16,.. (integer that is the square of an integer)
         *
         * intuition:
         * - brute force bottom up dp
         * - dp[i] -> min number of perfect squares to make value i
         *
         * O(N * sqrt(N)) time, O(N) space.
         */

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n); // max number of vals it takes is 1 * n
        // base cases
        dp[0] = 0;
        dp[1] = 1;

        for (int target = 2; target <= n; target++) {
            for (int curr = 1; curr <= Math.floor(Math.sqrt(target)); curr++) {
                int sqr = curr * curr;
                if (target - sqr < 0) {
                    break;
                }

                dp[target] = Math.min(dp[target], dp[target - sqr] + 1);
            }
        }

        return dp[n];
    }
}
// @lc code=end
