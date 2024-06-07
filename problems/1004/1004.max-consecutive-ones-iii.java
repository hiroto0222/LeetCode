/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        /*
         * max number of consecutive 1s if can flip at most k 0s
         *
         * intuition:
         * - sliding window
         * - such that nums[l, r] has k flips
         *
         * O(N) time, O(1) space
         */

        int ans = 0;
        int curr = 0;
        int l = 0;
        int r;

        for (r = 0; r < nums.length; r++) {
            if (nums[r] == 1) {
                continue;
            }

            if (curr + 1 <= k) {
                curr++;
                continue;
            }

            if (r - l > ans)
                ans = r - l;

            while (nums[l] == 1 && l <= r) {
                l++;
            }
            l++;
        }

        if (r - l > ans) {
            ans = r - l;
        }

        return ans;
    }
}
// @lc code=end
