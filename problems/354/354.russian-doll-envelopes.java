/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        /*
         * envelopes[i] = [width, height]
         * return max number of envelops that can be russian dolled.
         * for i to fit in j, width_i, height_i < width_j, height_j
         *
         * intuition:
         * - sort by width, then height.
         * - for each envelope, check if it fits in prev envelopes.
         * - dp[i] -> max number of envelopes including i.
         *
         * O(N^2) time, O(N) space
         */

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        int n = envelopes.length;
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = envelopes[i][1];
        }

        List<Integer> ans = new ArrayList<>();

        for (int height : heights) {
            // Find the position where 'height' can be placed in 'ans' using binary search.
            int pos = binarySearch(ans, height);

            // If 'height' is greater than all elements in 'ans', append it.
            if (pos == ans.size()) {
                ans.add(height);
            }
            // Otherwise, replace the element at the found position with 'height'.
            else {
                ans.set(pos, height);
            }
        }

        // The size of 'ans' represents the length of the longest increasing
        // subsequence.
        return ans.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end
