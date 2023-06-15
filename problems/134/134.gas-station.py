#
# @lc app=leetcode id=134 lang=python3
#
# [134] Gas Station
#


# @lc code=start
class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        # return starting gas station idx
        # ie:
        # gas  = [1 ,2 ,3 ,4,5]
        # cost = [3 ,4 ,5 ,1,2]
        # gain = [-2,-2,-2,3,3]
        # i = 4 -> 0 + 5 (2)
        # i = 0 -> 3 + 1 (3)
        # i = 1 -> 1 + 2 (4)

        n = len(gas)

        gain = []
        for i in range(n):
            gain.append(gas[i] - cost[i])

        if sum(gain) < 0:
            return -1

        s, curr_sum = 0, 0
        for i in range(n):
            curr_sum += gain[i]
            if curr_sum < 0:
                s = i + 1
                curr_sum = 0

        return s


# @lc code=end
