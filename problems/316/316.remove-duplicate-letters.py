#
# @lc app=leetcode id=316 lang=python
#
# [316] Remove Duplicate Letters
#

# @lc code=start
class Solution(object):
    def removeDuplicateLetters(self, s):
        # create hash of last seen idx of each char
        # if in stack: continue
        # if not in stack:
        #  - if stack[-1] > curr && hash[stack[-1]] > i then pop
        #  - once done, push
        
        stack = []
        seen = set()
        last_idx = {}

        for i, char in enumerate(s):
            last_idx[char] = i

        for i, char in enumerate(s):
            if char in seen: continue
                
            while stack:
                if stack[-1] > char and last_idx[stack[-1]] > i:
                    seen.remove(stack[-1])
                    stack.pop()
                else:
                    break

            seen.add(char)
            stack.append(char)
            
        return "".join(stack)
        
# @lc code=end

