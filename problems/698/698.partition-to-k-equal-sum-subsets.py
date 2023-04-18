#
# @lc app=leetcode id=698 lang=python3
#
# [698] Partition to K Equal Sum Subsets
#


# @lc code=start
class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        """
        1. if sum(nums) % k == 1 then false
        2. target = sum(nums) // k
        3. find subset == target, keep track of used nums
        """

        if sum(nums) % k != 0:
            return False

        nums.sort(reverse=True)
        target = sum(nums) // k
        used = [False] * len(nums)

        def backtrack(i, k, curr_sum):
            if k == 0:
                return True

            if curr_sum == target:
                return backtrack(0, k - 1, 0)

            for j in range(i, len(nums)):
                if j > 0 and not used[j - 1] and nums[j - 1] == nums[j]:
                    continue

                if used[j] or curr_sum + nums[j] > target:
                    continue

                used[j] = True
                if backtrack(j + 1, k, curr_sum + nums[j]):
                    return True
                used[j] = False

            return False

        return backtrack(0, k, 0)


# @lc code=end
