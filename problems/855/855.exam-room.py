#
# @lc app=leetcode id=855 lang=python3
#
# [855] Exam Room
#


# @lc code=start

from bisect import insort
from typing import List


class ExamRoom:
    def __init__(self, n: int):
        self.n: int = n
        self.students: List[int] = []

    def seat(self) -> int:
        """
        sit such that distance to closest person is maximized
        1. if multiple, pick seat with lowest number
        2. if no one, pick seat 0
        """
        if not self.students:
            self.students.append(0)
            return 0

        dist, seat = self.students[0], 0
        for i, c in enumerate(self.students):
            if i > 0:
                curr_dist = (c - self.students[i - 1]) // 2
                if curr_dist > dist:
                    dist = curr_dist
                    seat = self.students[i - 1] + curr_dist

        if self.n - 1 - self.students[-1] > dist:
            seat = self.n - 1

        insort(self.students, seat)
        return seat

    def leave(self, p: int) -> None:
        self.students.remove(p)


# Your ExamRoom object will be instantiated and called as such:
# obj = ExamRoom(n)
# param_1 = obj.seat()
# obj.leave(p)
# @lc code=end
