/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        /*
         * return minimum number of arrows to burst all balloons
         * a balloon can be burst if arrow is shot at x where
         * xstart <= x <= xend
         *
         * [1,6], [2,8], [7,12], [10,16]
         *
         * intuition:
         * - sort by start time
         * - merge overlapping intervals
         * - start with max arrows n
         * - every time we see overlapping intervals, decrement n
         *
         * O(NlogN) time, O(1) space
         */

        int n = points.length;
        int res = n;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int[] prev = points[0];

        for (int i = 1; i < n; i++) {
            int[] curr = points[i];
            // if overlapping, merge and decrement cnt
            if (curr[0] <= prev[1]) {
                res--;
                prev = new int[] { curr[0], Math.min(prev[1], curr[1]) };
            } else {
                prev = curr;
            }
        }

        return res;
    }
}
// @lc code=end
