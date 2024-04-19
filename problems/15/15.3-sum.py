#
# @lc app=leetcode id=15 lang=python3
#
# [15] 3Sum
#


# @lc code=start
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # find all unique triplets such that nums[i] + nums[j] + nums[k] = 0
        # nums = [-1,0,1,2,-1,-4]
        # -> [[-1,-1,2],[-1,0,1]]
        # sort nums
        # [-4,-1,-1,0,1,2]
        # for each nums[i], find all pair of values nums[l], nums[r] such that equal 0
        # as unique triplets, if found skip all consecutive nums[l]
        # time O(NlogN) + O(N^2) = O(N^2), space O(N)

        n = len(nums)
        nums.sort()
        res = []

        for i in range(n):
            if nums[i] > 0:
                # sum will always be greater than 0, so break
                break

            if i > 0 and nums[i] == nums[i - 1]:
                # previously seen so skip
                continue

            l, r = i + 1, n - 1
            while l < r:
                curr_sum = nums[i] + nums[l] + nums[r]
                if curr_sum > 0:
                    r -= 1
                elif curr_sum < 0:
                    l += 1
                else:
                    res.append([nums[i], nums[l], nums[r]])
                    l += 1
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1

        return res


# @lc code=end
