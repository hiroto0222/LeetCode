/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        /*
         * return number of combinations of nums that add up to target.
         * different sequences (1,1,2) and (1,2,1) are counted.
         * 1 <= target <= 1000
         *
         * intuition:
         * - bottom-up dp
         * - dp[i] = sum(dp[i - nums[j]])
         *
         * O(N * M) time, O(M) space. where M is target
         */

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int k = 1; k <= target; k++) {
            for (int num : nums) {
                if (k - num >= 0) {
                    dp[k] += dp[k - num];
                }
            }
        }

        return dp[target];
    }
}
// @lc code=end
