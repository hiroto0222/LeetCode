#
# @lc app=leetcode id=155 lang=python3
#
# [155] Min Stack
#

# @lc code=start
class MinStack:
    # O(1) for each method
    # cannot use heapq as O(logn) to pop
    # keep stack for only updated mins

    def __init__(self):
        self.stack = []
        self.mins = []

    def push(self, val: int) -> None:
        if not self.mins:
            self.mins.append(val)
        elif val <= self.mins[-1]:
            self.mins.append(val)
        self.stack.append(val)

    def pop(self) -> None:
        if self.mins and self.top() == self.mins[-1]:
            self.mins.pop()
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.mins[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
# @lc code=end

