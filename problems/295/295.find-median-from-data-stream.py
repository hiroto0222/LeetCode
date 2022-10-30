#
# @lc app=leetcode id=295 lang=python3
#
# [295] Find Median from Data Stream
#

# @lc code=start
import bisect

class MedianFinder:

    def __init__(self):
        self.arr = []
        self.arrLen = 0

    def addNum(self, num: int) -> None:
        bisect.insort(self.arr, num)
        self.arrLen += 1

    def findMedian(self) -> float:
        if self.arrLen % 2 == 0:
            return (self.arr[self.arrLen // 2 - 1] + self.arr[self.arrLen // 2]) / 2
        else:
            return (self.arr[self.arrLen // 2])


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
# @lc code=end

