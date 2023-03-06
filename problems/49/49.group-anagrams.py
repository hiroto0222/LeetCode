#
# @lc app=leetcode id=49 lang=python3
#
# [49] Group Anagrams
#

# @lc code=start
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # group anagrams together
        # strs = ["eat", "tea", "tan", "ate"] -> [["eat", "tea", "ate"], ["tan"]]
        # strs = ["abc"] -> [["abc"]]
        # strs = [""] -> [[""]]
        # 1. O(N * MlogM) time, O(N) space
        # 2. use array of size 26 to count all letters -> use as hashmap key
        #    O(N * M) time, O(N) space
        
        seen = defaultdict(list)
        for word in strs:
            cnt = [0] * 26
            for char in word:
                cnt[ord(char) - ord('a')] += 1
            seen[tuple(cnt)].append(word)
        
        return seen.values()


# @lc code=end

