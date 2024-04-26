#
# @lc app=leetcode id=383 lang=python3
#
# [383] Ransom Note
#

# @lc code=start
from collections import defaultdict


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        # true if string ransomNote can be constructed using letters once from magazine
        # store hashmap of available letters and count
        # time O(N), space O(N)

        letters = defaultdict(int)

        # populate hashmap
        for c in magazine:
            letters[c] += 1

        for c in ransomNote:
            if c not in letters or letters[c] == 0:
                return False
            letters[c] -= 1

        return True


# @lc code=end
