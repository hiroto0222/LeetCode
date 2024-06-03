/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        // reverse order of vowels only
        // s = "leetcode" -> "eeoe" -> "eoee"
        // s = "leotcede"
        // 2 pointers swap
        // O(N) time, O(N) space

        int l = 0;
        int r = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] ans = s.toCharArray();

        while (l < r) {
            while (l < r && vowels.indexOf(ans[l]) == -1) {
                l++;
            }

            while (l < r && vowels.indexOf(ans[r]) == -1) {
                r--;
            }

            // swap l and r
            char tmp = ans[l];
            ans[l] = ans[r];
            ans[r] = tmp;
            l++;
            r--;
        }

        return new String(ans);
    }
}
// @lc code=end
