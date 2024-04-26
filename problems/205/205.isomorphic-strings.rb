#
# @lc app=leetcode id=205 lang=ruby
#
# [205] Isomorphic Strings
#

# @lc code=start
# @param {String} s
# @param {String} t
# @return {Boolean}
def is_isomorphic(s, t)
  s_to_t = {}
  t_to_s = {}

  (0...s.length).each do |i|
    s_to_t[s[i]] = t[i] unless s_to_t[s[i]]
    t_to_s[t[i]] = s[i] unless t_to_s[t[i]]
    return false if s_to_t[s[i]] != t[i] || t_to_s[t[i]] != s[i]
  end

  true
end
# @lc code=end
