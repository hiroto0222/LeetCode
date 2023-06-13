#
# @lc app=leetcode id=1071 lang=python3
#
# [1071] Greatest Common Divisor of Strings
#


# @lc code=start
class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        # t divides s iff s = n * t
        len1, len2 = len(str1), len(str2)

        def valid(k):
            if len1 % k or len2 % k:
                return False

            n1, n2 = len1 // k, len2 // k
            base = str1[:k]

            return base * n1 == str1 and base * n2 == str2

        for i in range(min(len1, len2), 0, -1):
            if valid(i):
                return str1[:i]

        return ""


# @lc code=end
