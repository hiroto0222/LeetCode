#
# @lc app=leetcode id=125 lang=python3
#
# [125] Valid Palindrome
#


# @lc code=start
class Solution:
    def isPalindrome(self, s: str) -> bool:
        # 2 pointer approach
        # time O(N), space O(1)

        s = "".join(filter(str.isalnum, s.lower()))
        n = len(s)
        l, r = 0, n - 1

        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1

        return True


# @lc code=end
