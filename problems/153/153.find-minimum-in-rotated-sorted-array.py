#
# @lc app=leetcode id=153 lang=python3
#
# [153] Find Minimum in Rotated Sorted Array
#

# @lc code=start
class Solution:
    def findMin(self, nums: List[int]) -> int:
        # if: array is already sorted -> nums[0]
        # else: want to find point of descent
        # binary search

        n = len(nums)
        l, r = 0, n - 1

        if nums[l] <= nums[r]:  # in order
            return nums[0]

        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid + 1] < nums[mid]:
                return nums[mid + 1]
            
            if nums[mid - 1] > nums[mid]:
                return nums[mid]
            
            if nums[mid] > nums[0]:
                l = mid + 1
            else:
                r = mid - 1

        
# @lc code=end