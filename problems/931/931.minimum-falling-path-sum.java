import java.util.Arrays;

/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // bottom up (tabulation)

        Integer inf = Integer.MAX_VALUE;
        int n = matrix.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int left = j <= 0 ? inf : matrix[i + 1][j - 1];
                int mid = matrix[i + 1][j];
                int right = j >= n - 1 ? inf : matrix[i + 1][j + 1];
                matrix[i][j] += Math.min(Math.min(left, mid), right);
            }
        }

        return Arrays.stream(matrix[0]).min().getAsInt();
    }
}
// @lc code=end
