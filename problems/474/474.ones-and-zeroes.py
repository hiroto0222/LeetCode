#
# @lc app=leetcode id=474 lang=python3
#
# [474] Ones and Zeroes
#


# @lc code=start
class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        """
        find subset such that
            at most m x "0"
            at most n x "1"
        return size of the largest subset

        eg:
        strs = ["10","0001","111001","1","0"], m = 5, n = 3

        dp[M][N]
        dp[i][j] -> largest number of items in subset for m = i, n = j
        """

        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for s in strs:
            zero_cnt = s.count("0")
            one_cnt = len(s) - zero_cnt

            for i in range(m, zero_cnt - 1, -1):
                for j in range(n, one_cnt - 1, -1):
                    dp[i][j] = max(dp[i][j], dp[i - zero_cnt][j - one_cnt] + 1)
            print(dp)

        return dp[m][n]


# @lc code=end
