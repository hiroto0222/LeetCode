/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
         * return the length of the longest strictly increasing subsequence.
         *
         * [0,1,0,3,2,3]
         * -> [0,1,2,3] -> 4
         *
         * intuition:
         * - dp bottom-up
         * - dp[i] -> stores the max length of subsequence from i
         *
         * O(N^2) time, O(N) space
         */

        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1; // base case

        for (int i = n - 2; i >= 0; i--) {
            int maxLen = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    maxLen = Math.max(maxLen, dp[j]);
                }
            }

            dp[i] = maxLen + 1;
        }

        int res = 1;
        for (int val : dp) {
            if (val > res) {
                res = val;
            }
        }

        return res;
    }
}
// @lc code=end
