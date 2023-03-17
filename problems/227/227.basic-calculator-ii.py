#
# @lc app=leetcode id=227 lang=python3
#
# [227] Basic Calculator II
#

# @lc code=start
class Solution:
    def calculate(self, s: str) -> int:
        curr = prev = res = 0
        curr_op = "+"
        n = len(s)
        i = 0
        
        while i < n:
            curr_char = s[i]

            if curr_char.isdigit():
                curr = int(curr_char)
                while i + 1 < len(s) and s[i + 1].isdigit():
                    curr = curr * 10 + int(s[i + 1])
                    i += 1
            
                if curr_op == "+":
                    res += curr
                    prev = curr
                elif curr_op == "-":
                    res -= curr
                    prev = -curr
                elif curr_op == "*":
                    res -= prev
                    res += prev * curr
                    prev = prev * curr
                else:
                    res -= prev
                    res += int(prev / curr)
                    prev = int(prev / curr)

            elif curr_char in "+-*/":
                curr_op = curr_char
            
            i += 1
        
        return res

        
# @lc code=end
