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
        ans = []
        q = deque()

        for i in range(k):
            if not q:
                q.append(nums[i])
            else:
                while q and nums[i] > q[-1]:
                    q.pop()
                q.append(nums[i])
        ans.append(q[0])
        
        for r in range(k, len(nums)):
            l = r - k
            if nums[l] == q[0]:
                q.popleft()
            if not q:
                q.append(nums[r])
            else:
                while q and nums[r] > q[-1]:
                    q.pop()
                q.append(nums[r])
            ans.append(q[0])
        
        return ans
        

# @lc code=end

