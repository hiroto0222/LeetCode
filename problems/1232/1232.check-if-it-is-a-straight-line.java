/*
 * @lc app=leetcode id=1232 lang=java
 *
 * [1232] Check If It Is a Straight Line
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // check if coordinates make a straight line in the XY plane
        // 2 <= n <= 1000
        // approach:
        // given 2 points, slope of (x0, y0) (x1, y1) must equal (x1, y1) (x2, y2)
        // -> (y2 - y1) / (x2 - x1) = (y1 - y0) / (x1 - x0)
        // -> (x1 - x0) * (y2 - y1) = (x2 - x1) * (y1 - y0)
        // -> dx * (y2 - y1) = dy * (x2 - x1)

        int n = coordinates.length;
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < n; i++) {
            int curr_dx = coordinates[i][0] - coordinates[i - 1][0];
            int curr_dy = coordinates[i][1] - coordinates[i - 1][1];
            if (dx * curr_dy != dy * curr_dx) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

