/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        /**
         * Find 2 lines that create the largest area rectangle
         *
         * intuition:
         * - 2 pointers
         * - greedily update l, r to find max area where
         * - if height[r] > height[l] -> increment l
         * - else -> decrement r
         * - continue till l == r, then return found max
         *
         * O(N) time, O(1) space
         */

        int l = 0;
        int r = height.length - 1;
        int currMax = 0;

        while (l < r) {
            int currArea = (r - l) * Math.min(height[l], height[r]);
            currMax = Math.max(currMax, currArea);

            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }

        return currMax;
    }
}
// @lc code=end
