import java.util.List;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    private Integer[][] cache;

    public int minimumTotal(List<List<Integer>> triangle) {
        // return minimum path sum from top to bottom
        int n = triangle.size();
        cache = new Integer[n][n];
        return dfs(0, 0, triangle);
    }

    private int dfs(int i, int j, List<List<Integer>> triangle) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        int path = triangle.get(i).get(j);
        if (i < triangle.size() - 1) {
            path += Math.min(
                    dfs(i + 1, j, triangle),
                    dfs(i + 1, j + 1, triangle));
        }

        cache[i][j] = path;
        return path;
    }

    private int bottomUp(List<List<Integer>> triangle) {
        // start from bottom to top

        int n = triangle.size();
        int[] dp = new int[n + 1]; // keep track of prev row

        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[n + 1];
            for (int j = 0; j <= i; j++) {
                curr[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
            dp = curr;
        }

        return dp[0];
    }
}
// @lc code=end
