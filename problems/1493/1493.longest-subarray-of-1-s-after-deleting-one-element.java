/*
 * @lc app=leetcode id=1493 lang=java
 *
 * [1493] Longest Subarray of 1's After Deleting One Element
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        /*
         * must remove 1 element
         * return size of longest subarray containing only 1s
         * return 0 otherwise
         *
         * intuition:
         * - sliding window
         *
         * O(N) time, O(1) space
         */

        int ans = 0;
        int cnt = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                cnt++;
            }

            while (cnt > 1) {
                if (nums[l] == 0) {
                    cnt--;
                }
                l++;
            }

            if (r - l > ans) {
                ans = r - l;
            }
        }

        return ans;
    }
}
// @lc code=end
