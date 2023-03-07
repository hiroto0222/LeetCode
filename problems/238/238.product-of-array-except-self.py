#
# @lc app=leetcode id=238 lang=python3
#
# [238] Product of Array Except Self
#

# @lc code=start
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # return array ans such that ans[i] is product of all elements of nums except nums[i]
        # nums = [1, 2, 3, 4] -> [24, 12, 8, 6]
        # nums = [-1, 1, 0, -3, 3] -> [0, 0, 9, 0, 0]
        
        # prefix product
        # pre = [1, 2, 6, 24]
        # post = [24, 24, 12, 4]
        # ans[i] -> pre[i - 1] * post[i + 1]
        # O(N) time, O(N) space

        n = len(nums)
        ans = [1] * n
        pre, post = [nums[0]] * n, [nums[-1]] * n
        for i in range(1, n):
            ans[i] = pre[i - 1] * ans[i]
            pre[i] = pre[i - 1] * nums[i]
        for i in range(n - 2, -1, -1):
            ans[i] = post[i + 1] * ans[i]
            post[i] = post[i + 1] * nums[i]
                
        return ans
        
        
# @lc code=end