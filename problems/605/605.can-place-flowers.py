#
# @lc app=leetcode id=605 lang=python3
#
# [605] Can Place Flowers
#


# @lc code=start
class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        if n == 0:
            return True

        for i in range(len(flowerbed)):
            if flowerbed[i]:
                continue

            valid = True
            if i > 0 and flowerbed[i - 1]:
                valid = False
            if i < len(flowerbed) - 1 and flowerbed[i + 1]:
                valid = False

            if valid:
                flowerbed[i] = 1
                n -= 1

            if n <= 0:
                return True

        return False


# @lc code=end
