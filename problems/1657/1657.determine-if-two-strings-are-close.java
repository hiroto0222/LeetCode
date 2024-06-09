/*
 * @lc app=leetcode id=1657 lang=java
 *
 * [1657] Determine if Two Strings Are Close
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        /*
         * 2 strings considered close if:
         * 1. swap 2 existing chars
         * 2. transform every occurence of 1 existing char with another
         *
         * observation:
         * "cabbba" "abbccc"
         * 1. len(word1) must equal len(word2)
         * 2. the only way to add characters is operation 2 *
         *
         * intuition:
         * 1. store freq1, freq2 arrays of size 26,
         * freq1[i] stores ith letter's cnt in word1
         * 2. check precense of characters
         * 3. check occurences of characters (as long as same value of occurences, the
         * character does not matter)
         *
         * O(NlogN) time, O(1) space
         */

        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a'] += 1;
            freq2[word2.charAt(i) - 'a'] += 1;
        }

        // check precense of characters
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] > 0) || (freq1[i] > 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // check occurences
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
