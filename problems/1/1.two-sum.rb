#
# @lc app=leetcode id=1 lang=ruby
#
# [1] Two Sum
#

# @lc code=start
# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
  cache = {}
  nums.each_with_index do |num, i|
    if cache.include?(num)
      return [cache[num], i]
    else
      cache[target - num] = i
    end
  end
end
# @lc code=end

