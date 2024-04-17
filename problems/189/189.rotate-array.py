#
# @lc app=leetcode id=189 lang=python3
#
# [189] Rotate Array
#


# @lc code=start
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # nums = [1,2,3,4,5,6,7], k = 3
        # -> [5,6,7,1,2,3,4]
        # 1. reverse nums
        # 2. reverse from [0, k-1]
        # 3. reverse from [k, n]

        n = len(nums)
        k = k % n

        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, n - 1)

    def reverse(self, nums, from_idx, to_idx):
        while from_idx < to_idx:
            nums[from_idx], nums[to_idx] = nums[to_idx], nums[from_idx]
            from_idx += 1
            to_idx -= 1


# @lc code=end
