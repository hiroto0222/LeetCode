#
# @lc app=leetcode id=345 lang=python3
#
# [345] Reverse Vowels of a String
#


# @lc code=start
class Solution:
    def reverseVowels(self, s: str) -> str:
        # leetcode -> eeoe -> eoee

        vowels = "aeiouAEIOU"
        res = list(s)
        n = len(s)

        def findLeft(i):
            while i < n:
                if s[i] in vowels:
                    break
                i += 1
            return i

        def findRight(i):
            while i >= 0:
                if s[i] in vowels:
                    break
                i -= 1
            return i

        l, r = findLeft(0), findRight(n - 1)

        while l < r:
            res[l], res[r] = res[r], res[l]
            l = findLeft(l + 1)
            r = findRight(r - 1)

        return "".join(res)


# @lc code=end
