#
# @lc app=leetcode id=946 lang=python3
#
# [946] Validate Stack Sequences
#


# @lc code=start
class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        """
        pushed = [1,2,3,4,5]
        popped = [4,5,3,2,1]

        while len(popped) > 0 and i < len(pushed) -> keep pushing and popping
        """

        stack = []
        i, j = 0, 0
        while i < len(pushed) and j < len(popped):
            stack.append(pushed[i])
            while stack and j < len(popped):
                if stack[-1] == popped[j]:
                    stack.pop()
                    j += 1
                else:
                    break
            i += 1

        return len(stack) == 0


# @lc code=end
