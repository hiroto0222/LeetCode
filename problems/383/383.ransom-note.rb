#
# @lc app=leetcode id=383 lang=ruby
#
# [383] Ransom Note
#

# @lc code=start
# @param {String} ransom_note
# @param {String} magazine
# @return {Boolean}
def can_construct(ransom_note, magazine)
  letters = Hash.new(0)

  magazine.chars.each do |c|
    letters[c] += 1
  end

  ransom_note.chars.each do |c|
    return false if (letters[c]).zero?

    letters[c] -= 1
  end

  true
end
# @lc code=end
