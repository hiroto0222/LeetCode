#
# @lc app=leetcode id=347 lang=python3
#
# [347] Top K Frequent Elements
#

# @lc code=start
from heapq import heappush, heappop
from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # return k most frequent elements from nums
        # nums = [1, 1, 1, 2, 2, 3], k = 2 -> [1, 2]
        # using a maxheap then popping k times
        # O(N * log K)
        
        cnts = Counter(nums)
        heap = []
        for num, cnt in cnts.items():
            heappush(heap, (cnt, num))
            if len(heap) > k:
                heappop(heap) # keep popping min vals in heap till k most frequent are left
        
        return [val for k, val in heap]


# @lc code=end

