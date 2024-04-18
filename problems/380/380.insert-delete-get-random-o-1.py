#
# @lc app=leetcode id=380 lang=python3
#
# [380] Insert Delete GetRandom O(1)
#

# @lc code=start
import random
from collections import defaultdict


class RandomizedSet:
    # keep track of values in a set
    # get random value from set
    # average O(1) time
    # set keeps track of index
    # store list of vals for random

    def __init__(self):
        self.set_vals = defaultdict(int)  # holds index of value in list_vals
        self.list_vals = []

    def insert(self, val: int) -> bool:
        if val in self.set_vals:
            return False

        self.list_vals.append(val)
        self.set_vals[val] = len(self.list_vals) - 1
        return True

    def remove(self, val: int) -> bool:
        if val not in self.set_vals:
            return False

        # if last element, just pop
        if self.set_vals[val] == len(self.list_vals) - 1:
            self.set_vals.pop(val)
            self.list_vals.pop()
        # if not last element, swap with last and pop
        else:
            idx = self.set_vals[val]
            last_val = self.list_vals[-1]

            self.list_vals[idx] = last_val
            self.set_vals[last_val] = idx

            self.set_vals.pop(val)
            self.list_vals.pop()

        return True

    def getRandom(self) -> int:
        rand_i = random.randint(0, len(self.list_vals) - 1)
        return self.list_vals[rand_i]


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
# @lc code=end
