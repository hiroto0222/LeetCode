#
# @lc app=leetcode id=1657 lang=python3
#
# [1657] Determine if Two Strings Are Close
#


# @lc code=start
from collections import Counter


class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        # close if
        # 1. swap any 2 chars (abcde -> aecdb)
        # 2. transform every occurrence of one existing character into another existing character, and do the same with the other character.
        #    aacabb -> bbcbaa

        # if len(word1) != len(word2) -> false
        # else
        #   if occurences of chars are equal for both word1 and word2 -> true
        #   else check if occurences of chars can be made equal by exchanging (2)
        #       can check by sorting occurences and comparing

        # ie:
        # word1 = "cabbba", {"a": 2, "b": 3, "c": 1}
        # word2 = "abbccc", {"a": 1, "b": 2, "c": 3}

        if len(word1) != len(word2):
            return False

        c1 = Counter(word1)
        c2 = Counter(word2)

        if c1 == c2:
            return True

        if set(c1.keys()) != set(c2.keys()):
            return False

        return sorted(c1.values()) == sorted(c2.values())


# @lc code=end
