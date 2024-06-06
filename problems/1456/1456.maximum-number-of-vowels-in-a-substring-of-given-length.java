/*
 * @lc app=leetcode id=1456 lang=java
 *
 * [1456] Maximum Number of Vowels in a Substring of Given Length
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        /*
         * max number of vowels in substring length k
         * all lower case
         *
         * intuition:
         * - sliding window
         *
         * O(N) time, O(1) space
         */

        String vowels = "aeiou";
        int currMax = 0;
        int l = 0;
        int currSum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currSum++;
            }

            if (i >= k - 1) {
                // update curr max
                if (currSum > currMax)
                    currMax = currSum;

                // start of window was a vowel
                if (vowels.indexOf(s.charAt(l)) != -1) {
                    currSum--;
                }
                l++;
            }
        }

        return currMax;
    }
}
// @lc code=end
