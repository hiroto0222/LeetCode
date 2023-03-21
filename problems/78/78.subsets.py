#
# @lc app=leetcode id=78 lang=python3
#
# [78] Subsets
#

# @lc code=start
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # 1. bit combinations
        # 2**n combinations
        
        ans = []
        n = len(nums)
        for i in range(2**n):
            curr = []
            for j in range(n):
                if (i >> j) & 1:
                    curr.append(nums[j])
            ans.append(curr)
        
        return ans
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # 2. dfs
        # backtracking

        ans = []
        curr = []

        def dfs(i):
            if i >= len(nums):
                ans.append(curr.copy())
                return
            
            # include
            curr.append(nums[i])
            dfs(i + 1)

            # dont include
            curr.pop()
            dfs(i + 1)

        dfs(0)
        return ans
    
# @lc code=end
