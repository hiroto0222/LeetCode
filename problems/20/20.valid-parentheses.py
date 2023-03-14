#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        # (), [], {}
        # keep stack of open
        
        close = {")": "(", "]": "[", "}": "{"}
        stack = []

        for char in s:
            if char not in close:
                stack.append(char)
                continue
            
            if stack and stack[-1] == close[char]:
                stack.pop()
            else:
                return False
        
        return len(stack) == 0
        
# @lc code=end

