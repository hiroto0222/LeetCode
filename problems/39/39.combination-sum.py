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

        def helper(i, curr_sum, curr_combo):
            if curr_sum == target:
                res.append(curr_combo.copy())
                return
            if i >= len(candidates) or curr_sum > target:
                return
            
            curr_combo.append(candidates[i])
            helper(i, curr_sum + candidates[i], curr_combo)
            curr_combo.pop()
            helper(i + 1, curr_sum, curr_combo)
        
        helper(0, 0, [])
        return res

# @lc code=end

