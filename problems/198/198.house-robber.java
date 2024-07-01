/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        /*
         * cannot rob 2 adjacent houses.
         * return max amount of money that can be robbed
         *
         * intuition:
         * - dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
         * - depends only on prev 2
         *
         * O(N) time, O(1) space
         */

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }

        return curr;
    }
}
// @lc code=end
