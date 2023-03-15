#
# @lc app=leetcode id=22 lang=python3
#
# [22] Generate Parentheses
#

# @lc code=start
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # keep track of number of open, close
        # recursive
        # height of decision tree -> 2n
        # O(2^2n) time, O(2^2n) space

        ans = []

        def helper(open, close, curr_seq):
            if open == n and close == n:
                ans.append(curr_seq)
                return
            
            if close > open or open > n or close > n:
                return
            
            helper(open + 1, close, curr_seq + "(")
            helper(open, close + 1, curr_seq + ")")
            return
        
        helper(1, 0, "(")
        
        return ans
        
# @lc code=end

