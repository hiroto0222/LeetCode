#
# @lc app=leetcode id=1431 lang=python3
#
# [1431] Kids With the Greatest Number of Candies
#


# @lc code=start
class Solution:
    def kidsWithCandies(
        self, candies: List[int], extraCandies: int
    ) -> List[bool]:
        n = len(candies)
        curr_max = max(candies)
        res = [False] * n

        for i, c in enumerate(candies):
            if c + extraCandies >= curr_max:
                res[i] = True

        return res


# @lc code=end
