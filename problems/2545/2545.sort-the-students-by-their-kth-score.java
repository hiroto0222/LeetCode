/*
 * @lc app=leetcode id=2545 lang=java
 *
 * [2545] Sort the Students by Their Kth Score
 */

// @lc code=start
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        // sort matrix by the kth exam (0-indexed) from highest to lowest
        // matrix only contains distinct integers
        // 1 <= m, n <= 250
        // approach:
        // brute force sort by swapping ith row with max from [i + 1, m]
        // O(N^2), but m,n is relatively small so should be ok

        int m = score.length;
        int n = score[0].length;
        for (int i = 0; i < m - 1; i++) {
            int currMax = score[i][k];
            int swapIndex = i;
            for (int j = i + 1; j < m; j++) {
                if (score[j][k] > currMax) {
                    currMax = score[j][k];
                    swapIndex = j;
                }
            }

            if (swapIndex > i) {
                for (int j = 0; j < n; j++) {
                    int temp = score[i][j];
                    score[i][j] = score[swapIndex][j];
                    score[swapIndex][j] = temp;
                }
            }
        }

        return score;
    }
}
// @lc code=end

