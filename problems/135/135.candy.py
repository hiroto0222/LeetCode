#
# @lc app=leetcode id=135 lang=python3
#
# [135] Candy
#


# @lc code=start
class Solution:
    def candy(self, ratings: List[int]) -> int:
        # each child must have atleast 1 candy
        # children with a higher rating get more candies than their neighbors
        # ie:
        # ratings = [0,1,2,4,3,2,1,0]
        # l_to_r  = [1,2,3,4,1,1,1,1]
        # r_to_l  = [1,1,1,5,4,3,2,1]
        # candies = [1,2,3,5,4,3,2,1]
        # -> candies[i] = max(l_to_r[i], r_to_l[i])

        n = len(ratings)

        l_to_r = [1] * n
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                l_to_r[i] = l_to_r[i - 1] + 1

        r_to_l = [1] * n
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                r_to_l[i] = r_to_l[i + 1] + 1

        res = 0
        for i in range(n):
            res += max(l_to_r[i], r_to_l[i])

        return res


# @lc code=end
