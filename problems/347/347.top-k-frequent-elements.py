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
        
        # cnts = Counter(nums)
        # heap = []
        # for num, cnt in cnts.items():
        #     heappush(heap, (cnt, num))
        #     if len(heap) > k:
        #         heappop(heap) # keep popping min vals in heap till k most frequent are left
        
        # return [val for k, val in heap]

        # have array cnts
        # i -> cnt, cnts[i] -> [list of elements]
        # have hashmap storing (element -> i)
        # O(N) time, O(N) space

        n = len(nums)
        indexs = Counter(nums)
        cnts = [[] for _ in range(n + 1)]
        for val, cnt in indexs.items():
            cnts[cnt].append(val)
        
        ans = []
        for i in range(n, -1, -1):
            while len(cnts[i]) > 0 and k > 0:
                ans.append(cnts[i].pop())
                k -= 1
        
        return ans


# @lc code=end