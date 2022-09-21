import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        String[][] board = new String[n][n];
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiags = new HashSet<>();
        Set<Integer> negDiags = new HashSet<>();

        backTrack(0, n, res, board, cols, posDiags, negDiags);
        return res;
    }

    private void backTrack(int row, int n, List<List<String>> res, String[][] board, Set<Integer> cols, Set<Integer> posDiags, Set<Integer> negDiags) {
        if (row == n) {
            res.add(new ArrayList<>(addBoard(board, n)));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || posDiags.contains(row + col) || negDiags.contains(row - col)) {
                board[row][col] = ".";
                continue;
            }

            cols.add(col);
            posDiags.add(row + col);
            negDiags.add(row - col);
            board[row][col] = "Q";

            backTrack(row + 1, n, res, board, cols, posDiags, negDiags);

            board[row][col] = ".";
            cols.remove(col);
            posDiags.remove(row + col);
            negDiags.remove(row - col);
        }
    }

    private List<String> addBoard(String[][] board, int n) {
        List<String> currBoard = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String currRow = "";
            for (int j = 0; j < n; j++) {
                if (board[i][j] == null) {
                    board[i][j] = ".";
                }
                currRow += board[i][j];
            }
            currBoard.add(currRow);
        }

        return currBoard;
    }
}
// @lc code=end

