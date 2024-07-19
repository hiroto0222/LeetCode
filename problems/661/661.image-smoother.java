/*
 * @lc app=leetcode id=661 lang=java
 *
 * [661] Image Smoother
 */

// @lc code=start
class Solution {
    public int[][] imageSmoother(int[][] img) {
        /*
         * given m x n matrix, return matrix after applying 3 x 3 filter.
         * matrix[i][j] = avg(8 surrounding cells and matrix[i][j])
         *
         * intuition:
         * - brute force implmentation.
         */

        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int cnt = 0;
                for (int ii = i - 1; ii < i + 2; ii++) {
                    for (int jj = j - 1; jj < j + 2; jj++) {
                        if (ii >= 0 && ii < m && jj >= 0 && jj < n) {
                            sum += img[ii][jj];
                            cnt++;
                        }
                    }
                }

                res[i][j] = sum / cnt;
            }
        }

        return res;
    }
}
// @lc code=end
