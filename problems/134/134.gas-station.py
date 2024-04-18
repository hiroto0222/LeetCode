#
# @lc app=leetcode id=134 lang=python3
#
# [134] Gas Station
#


# @lc code=start
class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        # gas = [1,2,3,4,5]
        # cost = [3,4,5,1,2]
        # gain = [-2,-2,-2,3,3]
        # if the sum of gain is >= 0, then a path must exist
        # time O(N), space O(1)

        n = len(gas)

        if sum(gas) - sum(cost) < 0:
            return -1

        # if sum of gain is >= 0, find valid starting position
        # if the sum at any point is < 0 then the current starting position is invalid, so reset
        res = 0
        curr_sum = 0
        for i in range(n):
            curr_sum += gas[i] - cost[i]
            if curr_sum < 0:
                res = i + 1
                curr_sum = 0

        return res


# @lc code=end
