#
# @lc app=leetcode id=72 lang=python3
#
# [72] Edit Distance
#

# @lc code=start
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        # min steps to convert word1 to word2
        # 1. insert character
        # 2. delete character
        # 3. replace character

        # if len(word1) == len(word2) == 0 then 0
        # if len(word1) == 0 then len(word2)
        # if len(word2) == 0 then len(word1)
        # if word1[i] == word2[j] then i+1, j+1
        # if word1[i] != word2[j] then
        #   if insert -> i, j+1
        #   if delete -> i+1, j
        #   if replace -> i+1, j+1
        # 2d dp and find min + 1

        dp = [[float('inf')] * (len(word2) + 1) for _ in range(len(word1) + 1)]
        for j in range(len(word2) + 1):
            dp[len(word1)][j] = len(word2) - j
        for i in range(len(word1) + 1):
            dp[i][len(word2)] = len(word1) - i
        
        for i in range(len(word1) - 1, -1, -1):
            for j in range(len(word2) - 1, -1, -1):
                if word1[i] == word2[j]:
                    dp[i][j] = dp[i + 1][j + 1]
                else:
                    dp[i][j] = 1 + min(dp[i + 1][j], dp[i][j + 1], dp[i + 1][j + 1])

        return dp[0][0]
        
# @lc code=end

