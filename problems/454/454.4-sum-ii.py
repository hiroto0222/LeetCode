#
# @lc app=leetcode id=454 lang=python3
#
# [454] 4Sum II
#

# @lc code=start
class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        # number of tuples (i, j, k, l) such that
        # nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
        # 1. split arrays into 2 groups
        # 2. create hashmap for sum of 1st group and keep count
        # 3. iterate through sums of 2nd group and check if -sum exists in hashmap

        res, dic = 0, {}
        for num1 in nums1:
            for num2 in nums2:
                if num1 + num2 not in dic:
                    dic[num1 + num2] = 1
                else:
                    dic[num1 + num2] += 1
        
        for num3 in nums3:
            for num4 in nums4:
                if -(num3 + num4) in dic:
                    res += dic[-(num3 + num4)]
        
        return res


# @lc code=end

