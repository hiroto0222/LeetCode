/*
 * @lc app=leetcode id=1619 lang=java
 *
 * [1619] Mean of Array After Removing Some Elements
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        /*
         * intuition:
         * - x = len(arr) / 20 is number of small/large elements to remove
         * - len(arr) is multiple of 20 where >= 20
         * - sort and remove first/last x elements.
         *
         * O(NlogN) time, O(1) space
         */

        Arrays.sort(arr);
        int n = arr.length;
        int x = arr.length / 20;

        double sum = 0;
        for (int val : arr) {
            sum += val;
        }
        // subtract x min elements
        for (int i = 0; i < x; i++) {
            sum -= arr[i];
        }
        // subtract x max elements
        for (int i = n - 1; i >= n - x; i--) {
            sum -= arr[i];
        }

        return sum / (arr.length - 2 * x);
    }
}
// @lc code=end
