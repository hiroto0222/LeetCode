#
# @lc app=leetcode id=787 lang=python3
#
# [787] Cheapest Flights Within K Stops
#

# @lc code=start
from collections import defaultdict, deque
import math


class Solution:
    def findCheapestPrice(
        self, n: int, flights: List[List[int]], src: int, dst: int, k: int
    ) -> int:
        # Approach 1: using BFS
        # as bounded by at most k nodes, BFS works for S.P problem

        graph = defaultdict(dict)
        for u, v, w in flights:
            graph[u][v] = w

        cost = [math.inf for _ in range(n)]
        q = deque([[src, 0]])
        for _ in range(k + 1):
            size = len(q)
            for _ in range(size):
                [u, curr_cost] = q.popleft()
                for v in graph[u]:
                    next_cost = curr_cost + graph[u][v]
                    if next_cost < cost[v]:
                        cost[v] = next_cost
                        q.append([v, next_cost])

        if cost[dst] == math.inf:
            return -1

        return cost[dst]


# @lc code=end
