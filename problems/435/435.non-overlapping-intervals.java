/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
         * return minimum number of intervals to be removed to make the rest of
         * intervals non-overlapping.
         *
         * [[1,2],[2,10],[2,5],[5,10]]
         *
         * intuition:
         * - sort by starting order
         * - remove the ones that end later
         * - remove condition:
         * - if startj < endi, then remove i if endi > endj else j
         * - also update previous end position accordingly.
         *
         * O(NlogN) time, O(logN) space for sorting
         */

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int res = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // if curr start < prev end, must remove
            if (interval[0] < prevEnd) {
                res++;
                prevEnd = interval[1] > prevEnd ? prevEnd : interval[1];
            } else {
                prevEnd = interval[1];
            }
        }

        return res;
    }
}
// @lc code=end
