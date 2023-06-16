#
# @lc app=leetcode id=56 lang=python3
#
# [56] Merge Intervals
#


# @lc code=start
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # intervals[i] = [start, end]
        # merge all overlapping intervals, and return intervals
        # ie:
        # intervals = [[1,3],[2,6],[8,10],[15,18]]
        # [[1,6],[8,10],[15,18]]
        # sort in order of start time

        n = len(intervals)
        intervals.sort(key=lambda x: x[0])
        res = [intervals[0]]

        for i in range(1, n):
            start, end = intervals[i]
            if start <= res[-1][1]:
                res[-1][1] = max(res[-1][1], end)
            else:
                res.append([start, end])

        return res


# @lc code=end
