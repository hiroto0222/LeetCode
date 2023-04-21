#
# @lc app=leetcode id=1641 lang=python3
#
# [1641] Count Sorted Vowel Strings
#


# @lc code=start
class Solution:
    def countVowelStrings(self, n: int) -> int:
        """
        if n = 1
        [1, 1, 1, 1, 1] -> 5

        if n = 2
        [1, 2, 3, 4, 5] -> 15

        if n = 3
        [1, 3, 6, 10, 15]

        prefix sum
        """
        dp = [1] * 5
        res = 5
        for _ in range(1, n):
            res = 1
            for i in range(1, 5):
                dp[i] += dp[i - 1]
                res += dp[i]

        return res


# @lc code=end
