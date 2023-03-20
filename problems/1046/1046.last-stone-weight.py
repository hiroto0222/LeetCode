#
# @lc app=leetcode id=1046 lang=python3
#
# [1046] Last Stone Weight
#

# @lc code=start
from heapq import heappush, heappop

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        # use heap
        # create max heap
        maxHeap = []
        for val in stones: # O(N log N)
            heappush(maxHeap, -val)

        while len(maxHeap) > 1:
            y = -heappop(maxHeap)
            x = -heappop(maxHeap)
            if y != x:
                heappush(maxHeap, x - y)
        
        return 0 if len(maxHeap) == 0 else -maxHeap[0]

# @lc code=end

