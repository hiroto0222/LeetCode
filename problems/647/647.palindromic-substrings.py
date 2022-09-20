#
# @lc app=leetcode id=647 lang=python3
#
# [647] Palindromic Substrings
#

# @lc code=start
class Solution:
    def countSubstrings(self, s: str) -> int:
        # split counting palindromes to even and odd lengths
        # odd -> L = R and expand out
        # even -> R = L + 1 and expand out

        N = len(s)
        ans = 0
        for i in range(N):
            l = r = i
            while l >= 0 and r < N and s[l] == s[r]:
                ans += 1
                l -= 1
                r += 1
        
        for i in range(N):
            l = i
            r = i + 1
            while l >= 0 and r < N and s[l] == s[r]:
                ans += 1
                l -= 1
                r += 1
        
        return ans
        
# @lc code=end
