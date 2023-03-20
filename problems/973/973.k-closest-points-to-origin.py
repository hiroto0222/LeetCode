#
# @lc app=leetcode id=973 lang=python3
#
# [973] K Closest Points to Origin
#

# @lc code=start
from heapq import heapify, heappop

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # min heap of (dist, [x, y])
        # sqrt((x - 0)**2 + (y - 0)**2)
        # if x1**2 + y1**2 > x2**2 + y2**2 then (x2, y2) is closer

        minHeap = []
        for x, y in points:
            dist = x**2 + y**2
            minHeap.append((dist, [x, y]))
        
        heapify(minHeap)
        ans = []
        while k > 0:
            dist, point = heappop(minHeap)
            ans.append(point)
            k -= 1
        
        return ans
        

# @lc code=end