#
# @lc app=leetcode id=14 lang=python3
#
# [14] Longest Common Prefix
#


# @lc code=start
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        # choose 1st string as base string
        # iterate through each character of base against other words
        # if at any point condition is not met, return current prefix
        # time O(N*M), space O(1)

        base = strs[0]
        for i in range(len(base)):
            for j in range(1, len(strs)):
                if i == len(strs[j]) or base[i] != strs[j][i]:
                    # condition not met, so return current common prefix
                    return base[0:i]

        return base


# @lc code=end
