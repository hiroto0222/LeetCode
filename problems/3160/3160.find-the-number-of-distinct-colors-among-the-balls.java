/*
 * @lc app=leetcode id=3160 lang=java
 *
 * [3160] Find the Number of Distinct Colors Among the Balls
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        /*
         * each query [x,y] marks the ball x with the color y
         * 1 <= y <= 10**9
         * after each query, find the number of distinct colors among the balls
         * lack of a color is not distinct
         * limit <= 10**9
         *
         * [[1,4],[2,5],[1,3],[3,4]]
         * -> [1,2,2,3]
         *
         * intuition:
         * - keep track of current colors -> colors[i] = color of ball i
         * - keep hashmap -> cnt[color] -> number of balls with color
         * - if cnt == 0, remove color from hashmap
         * - for each query, return the size of the hashmap
         *
         * M = number of balls
         * N = number of queries
         * O(N) time, O(M) space
         */

        HashMap<Integer, Integer> colors = new HashMap<>();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            int prevColor = colors.getOrDefault(ball, 0);
            colors.put(ball, color);

            // if ball already assigned color, must remove such color from hashmap
            if (prevColor != 0) {
                cnt.put(prevColor, cnt.get(prevColor) - 1);
                if (cnt.get(prevColor) <= 0) {
                    cnt.remove(prevColor);
                }
            }

            // add new color to hashmap
            cnt.put(color, cnt.getOrDefault(color, 0) + 1);

            // add current distinct colors to res
            res[i] = cnt.size();
        }

        return res;
    }
}
// @lc code=end
