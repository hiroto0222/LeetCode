#
# @lc app=leetcode id=1664 lang=python3
#
# [1664] Ways to Make a Fair Array
#


# @lc code=start
class Solution:
    def waysToMakeFair(self, nums: List[int]) -> int:
        """
        choose 1 element and remove
        array is fair if sum(odd index) == sum(even index)
        return number of such elements

        eg:
        nums = [2, 1, 6, 4]
        i = 0 -> [1, 6, 4] -> 5 != 6
        i = 1 -> [2, 6, 4] -> 6 == 6
        i = 2 -> [2, 1, 4] -> 6 != 1
        i = 3 -> [2, 1, 6] -> 8 != 1
        return 1

        keep odd, even prefix sum
        """

        n = len(nums)
        odd_prefix, even_prefix = [0] * (n + 1), [0] * (n + 1)
        for i, num in enumerate(nums):
            odd_prefix[i] += odd_prefix[i - 1]
            even_prefix[i] += even_prefix[i - 1]
            if i % 2 == 0:
                even_prefix[i] += num
            else:
                odd_prefix[i] += num

        res = 0
        for i, num in enumerate(nums):
            even = even_prefix[i - 1] + (odd_prefix[n - 1] - odd_prefix[i])
            odd = odd_prefix[i - 1] + (even_prefix[n - 1] - even_prefix[i])
            res += even == odd

        return res


# @lc code=end
