#
# @lc app=leetcode id=1679 lang=python3
#
# [1679] Max Number of K-Sum Pairs
#


# @lc code=start
from collections import defaultdict


class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        # O(N) time, O(N) space

        res = 0
        seen = defaultdict(int)

        for val in nums:
            if seen[val] > 0:
                res += 1
                seen[val] -= 1
            else:
                seen[k - val] += 1

        return res


# @lc code=end
