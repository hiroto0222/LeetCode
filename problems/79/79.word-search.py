#
# @lc app=leetcode id=79 lang=python
#
# [79] Word Search
#

# @lc code=start
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        # DFS

        def dfs(i, j, k):
            if k == len(word):
                return True
            
            if i < 0 or i >= ROWS or j < 0 or j >= COLS or board[i][j] != word[k]:
                return False
            
            temp, board[i][j] = board[i][j], "."
            res = dfs(i + 1, j, k + 1) or dfs(i - 1, j, k + 1) or dfs(i, j + 1, k + 1) or dfs(i, j - 1, k + 1)
            board[i][j] = temp
            return res


        ROWS, COLS = len(board), len(board[0])
        for i in range(ROWS):
            for j in range(COLS):
                if board[i][j] == word[0] and dfs(i, j, 0):
                    return True
        
        return False


# @lc code=end

