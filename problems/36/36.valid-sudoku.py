#
# @lc app=leetcode id=36 lang=python3
#
# [36] Valid Sudoku
#


# @lc code=start
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # valid if
        # 1. each row contains digits 1-9 without repetition
        # 2. each col contains digits 1-9 without repetition
        # 3. each 3x3 contains digits 1-9 without repetition

        ROWS, COLS = 9, 9

        # check rows
        for r in range(ROWS):
            seen = set()
            for c in range(COLS):
                curr = board[r][c]
                if curr == ".":
                    continue
                if curr in seen:
                    return False
                seen.add(curr)

        # check cols
        for c in range(COLS):
            seen = set()
            for r in range(ROWS):
                curr = board[r][c]
                if curr == ".":
                    continue
                if curr in seen:
                    return False
                seen.add(curr)

        # check 3x3
        for c in range(0, COLS, 3):
            for r in range(0, ROWS, 3):
                seen = set()
                for i in range(9):
                    curr = board[r + (i // 3)][c + (i % 3)]
                    if curr == ".":
                        continue
                    if curr in seen:
                        return False
                    seen.add(curr)

        return True


# @lc code=end
