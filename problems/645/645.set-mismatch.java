/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        int[] res = new int[2];

        for (int i = 0; i < n; i++) {
            int curr = nums[i] - 1;
            if (dp[curr]) {
                res[0] = curr + 1;
            } else {
                dp[curr] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                res[1] = i + 1;
                break;
            }
        }

        return res;
    }
}
// @lc code=end

