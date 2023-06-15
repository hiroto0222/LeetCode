#
# @lc app=leetcode id=380 lang=python3
#
# [380] Insert Delete GetRandom O(1)
#

# @lc code=start
import random


class RandomizedSet:
    def __init__(self):
        self.set = {}
        self.vals = []

    def insert(self, val: int) -> bool:
        # inserts val if not present
        # return true if not present, false otherwise
        if val in self.set:
            return False

        self.set[val] = len(self.vals)
        self.vals.append(val)
        return True

    def remove(self, val: int) -> bool:
        # removes val if present
        # return true if present, false otherwise

        # {1: 1, 2: 2, 3: 0}
        # [3, 1, 2] want to remove 3
        # swap last element with element to remove
        # then remove from set and list
        if val not in self.set:
            return False

        last_ele = self.vals[-1]
        curr_ele_idx = self.set[val]

        # swap last ele idx with current ele idx
        self.set[last_ele] = curr_ele_idx
        self.vals[curr_ele_idx], self.vals[-1] = last_ele, val
        self.vals.pop()
        self.set.pop(val)

        return True

    def getRandom(self) -> int:
        # return random element from set
        return random.choice(self.vals)


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
# @lc code=end
