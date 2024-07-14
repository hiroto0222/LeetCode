/*
 * @lc app=leetcode id=1275 lang=java
 *
 * [1275] Find Winner on a Tic Tac Toe Game
 */

// @lc code=start
class Solution {
    public String tictactoe(int[][] moves) {
        /*
         * A places -> X
         * B places -> O
         * A plays first
         * return
         * - winner "A" or "B" if exists
         * - "Draw" (no more moves can be made and no winner exists)
         * - "Pending" (if more moves are possible no winner exists)
         */

        int[][] grid = new int[3][3]; // 1 -> A, 2 -> B, 0 -> empty
        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            if (i % 2 == 0) {
                grid[move[0]][move[1]] = 1; // A's move
            } else {
                grid[move[0]][move[1]] = 2; // B's move
            }
        }

        // check for winner
        // check row
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != 0 && grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2]) {
                return grid[i][0] == 1 ? "A" : "B";
            }
        }
        // check col
        for (int j = 0; j < 3; j++) {
            if (grid[0][j] != 0 && grid[0][j] == grid[1][j] && grid[0][j] == grid[2][j]) {
                return grid[0][j] == 1 ? "A" : "B";
            }
        }
        // check diag
        if (grid[0][0] != 0 && grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) {
            return grid[0][0] == 1 ? "A" : "B";
        }
        if (grid[2][0] != 0 && grid[2][0] == grid[1][1] && grid[2][0] == grid[0][2]) {
            return grid[2][0] == 1 ? "A" : "B";
        }

        // check for pending
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    return "Pending";
                }
            }
        }
        // else draw
        return "Draw";
    }
}
// @lc code=end
