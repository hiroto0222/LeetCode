#
# @lc app=leetcode id=57 lang=python3
#
# [57] Insert Interval
#


# @lc code=start
class Solution:
    def insert(
        self, intervals: List[List[int]], newInterval: List[int]
    ) -> List[List[int]]:
        # non-overlapping sorted by start time intervals
        # insert new interval into intervals
        # ie:
        # intervals = [[0,1],[3,5],[6,7],[8,10],[12,16]], newInterval = [2,9]
        # iterate until newInterval[0] <= intervals[i][1] (new start <= curr end)
        # O(N) time, O(N) space

        n = len(intervals)
        res = []
        idx = 0
        for i, interval in enumerate(intervals):
            s, e = interval
            if newInterval[0] > e:
                res.append(interval)
                continue

            if newInterval[0] < s:
                s = newInterval[0]

            while i < n and newInterval[1] > intervals[i][1]:
                i += 1

            if i == n:
                res.append([s, newInterval[1]])
            else:
                if newInterval[1] >= intervals[i][0]:
                    res.append([s, intervals[i][1]])
                else:
                    res.append([s, newInterval[1]])
                    i -= 1
            idx = i + 1
            break
        else:
            res.append(newInterval)
            return res

        while idx < n:
            res.append(intervals[idx])
            idx += 1

        return res


# @lc code=end
