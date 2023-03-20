#
# @lc app=leetcode id=703 lang=python3
#
# [703] Kth Largest Element in a Stream
#

# @lc code=start
from heapq import heappush, heappop

class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.heap = []
        self.k = k

        cnt = 0
        for val in nums:
            if cnt < k:
                cnt += 1
                heappush(self.heap, val)
            else:
                if val > self.heap[0]:
                    heappop(self.heap)
                    heappush(self.heap, val)

    def add(self, val: int) -> int:
        if len(self.heap) < self.k:
            heappush(self.heap, val)
        elif val > self.heap[0]:
            heappop(self.heap)
            heappush(self.heap, val)
        return self.heap[0]


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)
# @lc code=end

