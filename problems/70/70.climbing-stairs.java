/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        /*
         * takes n steps to reach top
         * each time can climb either 1 or 2 steps.
         * how many distinct ways can you climb to the top?
         *
         * n = 2
         * 1. 1 + 1
         * 2. 2
         *
         * intuition:
         * to reach step i, can take either 1 or 2 steps
         * dp[i] = dp[i - 1] + dp[i - 2]
         * only prev 2 matter
         *
         * O(N) time, O(1) space
         */

        int prev = 1;
        int curr = 1;

        for (int i = 1; i < n; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }

        return curr;
    }
}
// @lc code=end
