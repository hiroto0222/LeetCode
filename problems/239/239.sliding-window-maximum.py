#
# @lc app=leetcode id=239 lang=python
#
# [239] Sliding Window Maximum
#

# @lc code=start
from collections import deque

class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        # montonic decreasing queue
        # - can ignore all values less than max

        q = deque()
        ans = []

        for i in range(k):
            while q and q[-1] < nums[i]:
                q.pop()
            q.append(nums[i])
        ans.append(q[0])
        
        for r in range(k, len(nums)):
            l = r - k
            if nums[l] == q[0]:
                q.popleft()
            while q and q[-1] < nums[r]:
                q.pop()
            q.append(nums[r])
            ans.append(q[0])
        
        return ans
        

# @lc code=end

