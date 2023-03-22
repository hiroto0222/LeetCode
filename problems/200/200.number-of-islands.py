#
# @lc app=leetcode id=200 lang=python3
#
# [200] Number of Islands
#

# @lc code=start
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        islands = 0

        def bfs(i, j):
            stack = [[i, j]]
            while stack:
                for _ in range(len(stack)):
                    curr = stack.pop()
                    curr_i, curr_j = curr[0], curr[1]
                    grid[curr_i][curr_j] = "0"

                    for dx, dy in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
                        x = curr_i + dx
                        y = curr_j + dy
                        if (x >= 0 and x < ROWS and y >= 0 and y < COLS and grid[x][y] == "1"):
                            stack.append([x, y])

        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == "1":
                    islands += 1
                    bfs(i, j)
        
        return islands
        
# @lc code=end

