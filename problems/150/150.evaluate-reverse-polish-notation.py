#
# @lc app=leetcode id=150 lang=python3
#
# [150] Evaluate Reverse Polish Notation
#

# @lc code=start
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # "4 13 5 / +" -> (13 / 5) + 4
        # "2 1 + 3 *" -> (2 + 1) * 3
        # "10 6 9 3 + -11 * / * 17 + 5 +" -> ((10 * (6 / (9 + 3) * (-11)))) + 17 + 5
        # all input are valid RPN
        
        vals = []
        for token in tokens:
            if token in "+-*/":
                y = vals.pop()
                x = vals.pop()
                vals.append(self.compute(x, y, token))
            else:
                vals.append(int(token))
        
        return vals[-1]

    def compute(self, x, y, token):
        if token == "+":
            return x + y
        elif token == "-":
            return x - y
        elif token == "*":
            return x * y
        else:
            return int(x / y)

# @lc code=end