#
# @lc app=leetcode id=443 lang=python3
#
# [443] String Compression
#


# @lc code=start
class Solution:
    def compress(self, chars: List[str]) -> int:
        # modify in place
        # return len of new arr

        n = len(chars)
        curr_i = 0
        curr_char = chars[0]
        curr_cnt = 1

        for i in range(1, n):
            if chars[i] != curr_char:
                chars[curr_i] = curr_char
                curr_i += 1
                if curr_cnt > 1:
                    curr_cnt = str(curr_cnt)
                    for digit in curr_cnt:
                        chars[curr_i] = digit
                        curr_i += 1
                curr_char = chars[i]
                curr_cnt = 1
            else:
                curr_cnt += 1

        chars[curr_i] = curr_char
        curr_i += 1
        if curr_cnt > 1:
            curr_cnt = str(curr_cnt)
            for digit in curr_cnt:
                chars[curr_i] = digit
                curr_i += 1

        return curr_i


# @lc code=end
