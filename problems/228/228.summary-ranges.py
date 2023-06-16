#
# @lc app=leetcode id=228 lang=python3
#
# [228] Summary Ranges
#


# @lc code=start
class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        # return smallest sorted list of ranges
        # [1,2] -> "1->2"
        # [1,3] -> "1","3"

        n = len(nums)
        res = []

        if n == 0:
            return res

        idx = 0
        for i in range(n - 1):
            if nums[i] + 1 == nums[i + 1]:
                continue

            if idx == i:
                res.append(str(nums[i]))
            else:
                res.append("{}->{}".format(nums[idx], nums[i]))
            idx = i + 1

        if idx == n - 1:
            res.append(str(nums[-1]))
        else:
            res.append("{}->{}".format(nums[idx], nums[-1]))

        return res


# @lc code=end
