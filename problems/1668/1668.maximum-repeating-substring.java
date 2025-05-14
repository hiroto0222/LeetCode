/*
 * @lc app=leetcode id=1668 lang=java
 *
 * [1668] Maximum Repeating Substring
 */

// @lc code=start
class Solution {
    public int maxRepeating(String sequence, String word) {
        // a word is k-repeating, if word concatenated k times is a substring of sequence
        // return maximum k-repeating value

        int cnt = 0;
        String repeat = word;
        while (sequence.contains(repeat)) {
            repeat += word;
            cnt++;
        }

        return cnt;
    }
}
// @lc code=end

