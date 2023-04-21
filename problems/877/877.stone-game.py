#
# @lc app=leetcode id=877 lang=python3
#
# [877] Stone Game
#


# @lc code=start
from functools import cache


class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        """
        no. piles = even
        no. stones = odd

        each turn
        1. take all stones in pile[0]
        2. take all stones in pile[-1]
        when no more piles left, person with most stones win

        Alice starts, return True if alice wins else False

        eg:
        piles = [5,3,4,5]
        a -> piles[0] -> 5 -> [3,4,5]
        b -> piles[-1] -> 5 -> [3,4]
        a -> piles[-1] -> 4 -> [3]
        b -> piles[0] -> 3 -> []

        piles = [3,7,2,3]
        a -> piles[-1] -> 3 -> [3,7,2]
        b -> piles[0] -> 3 -> [7,2]
        a -> piles[0] -> 7 -> [2]
        b -> piles[0] -> 2 -> []

        recursion + cache
        """

        @cache
        def helper(l, r, isAlice):
            if l > r:
                return 0

            if isAlice:
                return max(
                    piles[l] + helper(l + 1, r, not isAlice),
                    piles[r] + helper(l, r - 1, not isAlice),
                )
            else:
                return min(
                    -piles[l] + helper(l + 1, r, not isAlice),
                    -piles[r] + helper(l, r - 1, not isAlice),
                )

        return helper(0, len(piles) - 1, True) > 0


# @lc code=end
