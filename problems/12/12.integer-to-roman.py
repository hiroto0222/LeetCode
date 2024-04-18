#
# @lc app=leetcode id=12 lang=python3
#
# [12] Integer to Roman
#


# @lc code=start
class Solution:
    def intToRoman(self, num: int) -> str:
        ones = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]
        tens = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]
        hrds = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]
        thds = ["", "M", "MM", "MMM"]

        return (
            thds[num // 1000]
            + hrds[(num % 1000) // 100]
            + tens[(num % 100) // 10]
            + ones[num % 10]
        )


# @lc code=end
