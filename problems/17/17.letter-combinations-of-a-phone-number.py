#
# @lc app=leetcode id=17 lang=python3
#
# [17] Letter Combinations of a Phone Number
#


# @lc code=start
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        # digits 2-9
        # backtrack
        # f(num, i)

        if not digits:
            return []

        nums = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz",
        }
        res = []

        def backtrack(curr_combo, i):
            if i >= len(digits):
                res.append(curr_combo)
                return

            for c in nums[digits[i]]:
                backtrack(curr_combo + c, i + 1)

        backtrack("", 0)

        return res


# @lc code=end
