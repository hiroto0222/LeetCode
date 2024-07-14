/*
 * @lc app=leetcode id=1314 lang=java
 *
 * [1314] Matrix Block Sum
 */

// @lc code=start
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        /*
         * given m x n matrix and k, return answer where:
         * answer[i][j] = sum(mat[r][c]) where
         * i - k <= r <= i + k
         * j - k <= c <= j + k
         * 0 <= r <= m
         * 0 <= c <= n
         *
         * intuition:
         * - brute force implementation
         *
         * O(M * N) time, O(M * N) space.
         */

        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int ii = Math.max(0, i - k); ii <= Math.min(m - 1, i + k); ii++) {
                    for (int jj = Math.max(0, j - k); jj <= Math.min(n - 1, j + k); jj++) {
                        res[i][j] += mat[ii][jj];
                    }
                }
            }
        }

        return res;
    }
}
// @lc code=end
