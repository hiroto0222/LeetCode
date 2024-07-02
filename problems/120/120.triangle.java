import java.util.List;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*
         * return min path sum from top to bottom.
         * can move from (i,j) to (i+1,j) or (i+1,j+1)
         *
         * bottom-up dp
         *
         * O(N) time, O(N) space where N is the height of the triangle
         */

        int n = triangle.size();
        int[] dp = new int[n];

        if (n == 1) {
            return triangle.get(0).get(0);
        }

        // populate base case
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int i = 0; i < triangle.get(row).size(); i++) {
                int curr = triangle.get(row).get(i);
                dp[i] = curr + Math.min(dp[i], dp[i + 1]);
            }
        }

        return dp[0];
    }
}
// @lc code=end
