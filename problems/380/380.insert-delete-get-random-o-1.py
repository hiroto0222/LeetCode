#
# @lc app=leetcode id=380 lang=python3
#
# [380] Insert Delete GetRandom O(1)
#

# @lc code=start
import random


class RandomizedSet:
    # keep track of values in a set
    # get random value from set
    # average O(1) time

    def __init__(self):
        self.vals = set()

    def insert(self, val: int) -> bool:
        if val in self.vals:
            return False
        self.vals.add(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self.vals:
            return False
        self.vals.remove(val)
        return True

    def getRandom(self) -> int:
        # time O(N)
        n = len(self.vals)
        rand_i = random.randint(0, n - 1)
        return list(self.vals)[rand_i]


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
# @lc code=end
