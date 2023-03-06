#
# @lc app=leetcode id=242 lang=python3
#
# [242] Valid Anagram
#

# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # can rearrange all letters in t to create s
        # s = "anagram"
        # t = "nagaram"
        # -> True
        
        if len(s) != len(t):
            return False
        
        countS, countT = {}, {}
        for i in range(len(s)):
            countS[s[i]] = 1 + countS.get(s[i], 0)
            countT[t[i]] = 1 + countT.get(t[i], 0)
        
        for char in countS:
            if countS.get(char, 0) != countT.get(char, 0):
                return False
        
        return True


# @lc code=end
