/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        /*
         * maximize number of points gained.
         * - pick any nums[i] and delete it to earn nums[i].
         * - after, must delete every element equal to nums[i] - 1 and nums[i] + 1
         *
         * intuition:
         * - 1 <= nums[i] <= 10^4 so create dp of value buckets
         * - for each case:
         * - dp[i] = max(dp[i] * i + dp[i + 2], dp[i + 1])
         * - where dp[i] * i + dp[i + 2] -> is take i
         * - dp[i + 1] is dont take i
         *
         * O(N) time, O(N) space
         */

        // find max
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int[] dp = new int[max + 3];

        // update counts
        for (int num : nums) {
            dp[num]++;
        }

        for (int num = max; num >= 0; num--) {
            dp[num] = Math.max(dp[num] * num + dp[num + 2], dp[num + 1]);
        }

        return dp[0];
    }
}
// @lc code=end
