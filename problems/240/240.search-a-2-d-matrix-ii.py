#
# @lc app=leetcode id=240 lang=python3
#
# [240] Search a 2D Matrix II
#

# @lc code=start
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        N, M = len(matrix), len(matrix[0])
        r, c = 0, M - 1  # start from top right

        while r < N and c >= 0:
            mid = matrix[r][c]

            if mid == target:
                return True
            
            if target < mid:
                c -= 1
            else:
                r += 1
        
        return False
        
        
# @lc code=end

