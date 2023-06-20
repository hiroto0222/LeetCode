#
# @lc app=leetcode id=392 lang=ruby
#
# [392] Is Subsequence
#

# @lc code=start
# @param {String} s
# @param {String} t
# @return {Boolean}
def is_subsequence(s, t)
    # return true if s is subsequence of t

    i, j = 0, 0
    while i < s.length && j < t.length
      if s[i] == t[j]
        i += 1
      end
      j += 1
    end

    return i == s.length
end
# @lc code=end

