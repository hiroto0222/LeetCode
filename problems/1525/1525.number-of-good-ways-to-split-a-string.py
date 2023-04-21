#
# @lc app=leetcode id=1525 lang=python3
#
# [1525] Number of Good Ways to Split a String
#


# @lc code=start
class Solution:
    def numSplits(self, s: str) -> int:
        """
        prefix sum from left, right
        """
        n = len(s)
        prefix, pref_set = [0] * n, set()
        suffix, suff_set = [0] * n, set()

        for i in range(n):
            j = n - i - 1
            pref_set.add(s[i])
            suff_set.add(s[j])
            prefix[i] = len(pref_set)
            suffix[j] = len(suff_set)

        res = 0
        for i in range(n - 1):
            if prefix[i] == suffix[i + 1]:
                res += 1

        return res


# @lc code=end
