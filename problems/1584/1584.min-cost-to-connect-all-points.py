#
# @lc app=leetcode id=1584 lang=python3
#
# [1584] Min Cost to Connect All Points
#

# @lc code=start
from heapq import heappop, heappush

class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        # manhattan dist -> abs(x1 - x2) + abs(y1 - y2)
        # Prims Algorithm
        # O(N^2 + N^2 log N) -> O(N^2 log N)

        n = len(points)
        adj = {i: [] for i in range(n)}
        for i in range(n):
            x1, y1 = points[i]
            for j in range(i + 1, n):
                x2, y2 = points[j]
                dist = abs(x1 - x2) + abs(y1 - y2)
                adj[i].append([dist, j])
                adj[j].append([dist, i])
        
        res = 0
        minHeap = [[0, 0]]
        visited = set()

        while len(visited) < n:
            dist1, u = heappop(minHeap)
            if u in visited: continue
            res += dist1
            visited.add(u)
            for dist2, v in adj[u]:
                if v not in visited:
                    heappush(minHeap, [dist2, v])

        return res

# @lc code=end
