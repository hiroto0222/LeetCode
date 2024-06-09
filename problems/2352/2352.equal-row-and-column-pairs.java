/*
 * @lc app=leetcode id=2352 lang=java
 *
 * [2352] Equal Row and Column Pairs
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        /*
         * return pairs (r, c) such that r equals c
         *
         * intuition:
         * 1. convert rows to strings, store as keys to hashmap
         *
         * O(N^2) time, O(N) space
         */

        Map<String, Integer> cnts = new HashMap<>();

        for (int[] row : grid) {
            String k = Arrays.toString(row);
            cnts.put(k, 1 + cnts.getOrDefault(k, 0));
        }

        int pairs = 0;
        for (int c = 0, n = grid.length; c < n; c++) {
            int[] col = new int[n];
            for (int r = 0; r < n; r++) {
                col[r] = grid[r][c];
            }
            pairs += cnts.getOrDefault(Arrays.toString(col), 0);
        }

        return pairs;
    }
}
// @lc code=end
