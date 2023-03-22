#
# @lc app=leetcode id=39 lang=python3
#
# [39] Combination Sum
#

# @lc code=start
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # recursively keep adding vals till exceeds
        res = []

        def dfs(i, curr_sum, curr_combo):
            if curr_sum == target:
                res.append(curr_combo.copy())
                return
            elif i >= len(candidates) or curr_sum > target:
                return
            
            # keep adding current val till exceeds
            curr_combo.append(candidates[i])
            dfs(i, curr_sum + candidates[i], curr_combo)

            # backtrack
            curr_combo.pop()
            dfs(i + 1, curr_sum, curr_combo)

        dfs(0, 0, [])
        return res

# @lc code=end
