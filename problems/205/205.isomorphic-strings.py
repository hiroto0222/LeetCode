#
# @lc app=leetcode id=205 lang=python3
#
# [205] Isomorphic Strings
#

# @lc code=start


class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        # ismorphic if chars in s can be replaced to get t
        # hashmap to store s->t, t->s char replacement
        # time O(N), space O(1)

        s_to_t, t_to_s = {}, {}
        for i in range(len(s)):
            if not s_to_t.get(s[i]):
                s_to_t[s[i]] = t[i]
            if not t_to_s.get(t[i]):
                t_to_s[t[i]] = s[i]
            if s_to_t[s[i]] != t[i] or t_to_s[t[i]] != s[i]:
                return False

        return True


# @lc code=end
