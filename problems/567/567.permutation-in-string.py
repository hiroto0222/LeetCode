#
# @lc app=leetcode id=567 lang=python3
#
# [567] Permutation in String
#

# @lc code=start
from collections import Counter

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        # true if s2 contains a permutation of s1
        # s1 = "ab", s2 = "eidbaoo" -> true
        # 1. if not valid char -> skip all
        # 2. if valid char but over cnt -> skip till can add curr char
        # s1 = "adc", s2 = "dadc"
        # s1 = "ab", a1 = "eidboaoo"
        # {"a": 0, "d": 0, "c": 1}

        cnts = Counter(s1)
        l = 0
        
        for r, c in enumerate(s2):
            if c in cnts and cnts[c] > 0:
                cnts[c] -= 1
            else:
                while s2[l] != c:
                    cnts[s2[l]] += 1
                    l += 1
                l += 1
            
            if r - l + 1 == len(s1):
                return True
            
        return False

        
# @lc code=end

