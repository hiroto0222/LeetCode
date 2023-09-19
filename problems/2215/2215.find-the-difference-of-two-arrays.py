#
# @lc app=leetcode id=2215 lang=python3
#
# [2215] Find the Difference of Two Arrays
#


# @lc code=start
class Solution:
    def findDifference(
        self, nums1: List[int], nums2: List[int]
    ) -> List[List[int]]:
        # answer[0] -> all distinct integers in nums1 not in nums2
        # answer[1] -> all distinct integers in nums2 not in nums1

        ans1, ans2 = [], []
        set1, set2 = set(nums1), set(nums2)
        for val in set1:
            if val not in set2:
                ans1.append(val)
        for val in set2:
            if val not in set1:
                ans2.append(val)

        return [ans1, ans2]


# @lc code=end
