#
# @lc app=leetcode id=983 lang=python3
#
# [983] Minimum Cost For Tickets
#

# @lc code=start


class Solution:
    def mincostTickets(self, days, costs):
        n = len(days)
        dp = {}

        def dfs(i):
            if i >= n:
                return 0
            if i in dp:
                return dp[i]

            dp[i] = float("inf")
            for d, c in zip([1, 7, 30], costs):
                j = i
                while j < n and days[j] < days[i] + d:
                    j += 1
                dp[i] = min(dp[i], c + dfs(j))

            return dp[i]

        return dfs(0)


# @lc code=end
