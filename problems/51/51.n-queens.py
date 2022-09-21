#
# @lc app=leetcode id=51 lang=python3
#
# [51] N-Queens
#

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        # seperate rows, cols, diagonals
        # keep track of placed col, placed posDiag, placed negDiag
        # recursive through each row

        cols = set()
        posDiags = set() # r + c
        negDiags = set() # r - c
        res = []
        board = [["."] * n for _ in range(n)]
        
        def backtrack(curr_row):
            if curr_row == n:
                # solution reached
                curr_board = ["".join(row) for row in board]
                res.append(curr_board)
            
            for col in range(n):
                if col in cols or (curr_row + col) in posDiags or (curr_row - col) in negDiags:
                    continue

                cols.add(col)
                posDiags.add(curr_row + col)
                negDiags.add(curr_row - col)
                board[curr_row][col] = "Q"

                backtrack(curr_row + 1)

                cols.remove(col)
                posDiags.remove(curr_row + col)
                negDiags.remove(curr_row - col)
                board[curr_row][col] = "."

        backtrack(0)
        return res
        
# @lc code=end

