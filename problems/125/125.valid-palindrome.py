#
# @lc app=leetcode id=125 lang=python3
#
# [125] Valid Palindrome
#

# @lc code=start
class Solution:
    def isPalindrome(self, s: str) -> bool:
        # 1. reverse sort and compare -> O(NlogN)
        # 2. two pointer -> O(N)
        # O(N) time, O(1) space
        
        l, r = 0, len(s) - 1
        while l < r:
            while l < r and not self.isAlphaNum(s[l]):
                l += 1
            while r > l and not self.isAlphaNum(s[r]):
                r -= 1
            if s[l].lower() != s[r].lower():
                return False
            l += 1
            r -= 1
        
        return True

    def isAlphaNum(self, c):
        return (ord("a") <= ord(c) <= ord("z")) or \
               (ord("A") <= ord(c) <= ord("Z")) or \
               (ord("0") <= ord(c) <= ord("9"))


# @lc code=end
