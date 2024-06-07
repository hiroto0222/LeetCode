/*
 * @lc app=leetcode id=1732 lang=java
 *
 * [1732] Find the Highest Altitude
 */

// @lc code=start
class Solution {
    public int largestAltitude(int[] gain) {
        /*
         * highest altitude
         *
         * intuition:
         * - iterate and keep track of max altitude
         *
         * O(N) time, O(1) space
         */

        int ans = 0;
        int prev = 0;
        for (int val : gain) {
            prev += val;
            if (prev > ans) {
                ans = prev;
            }
        }

        return ans;
    }
}
// @lc code=end
