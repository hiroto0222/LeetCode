#
# @lc app=leetcode id=73 lang=python3
#
# [73] Set Matrix Zeroes
#

# @lc code=start
class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        N, M = len(matrix), len(matrix[0])
        rows, cols = set(), set()

        for i in range(N):
            for j in range(M):
                if matrix[i][j] == 0:
                    rows.add(i)
                    cols.add(j)
        
        for i in range(N):
            for j in range(M):
                if i in rows or j in cols:
                    matrix[i][j] = 0
        
        
# @lc code=end

