#
# @lc app=leetcode id=743 lang=python3
#
# [743] Network Delay Time
#

# @lc code=start
from collections import defaultdict
from heapq import heappop, heappush

class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        edges = defaultdict(list)
        for u, v, w in times:
            edges[u].append((v, w))
        
        minHeap = [(0, k)]
        visited = set()
        res = 0

        while minHeap:
            w1, u = heappop(minHeap)
            if u in visited: continue
            visited.add(u)
            res = w1  # always min

            for v, w2 in edges[u]:
                if v not in visited:
                    heappush(minHeap, (w1 + w2, v))
        
        return res if len(visited) == n else -1

# @lc code=end
