/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        // intuition:
        // keep track of count and update point k
        // k never over takes i

        int k = 0;
        int currCount = 1;
        char currChar = chars[0];

        for (int i = 1; i < chars.length; i++) {
            // if equal, continue counting
            if (chars[i] == currChar) {
                currCount++;
                continue;
            }

            // if not equal, update
            chars[k] = currChar;
            if (currCount > 1) {
                String val = Integer.toString(currCount);
                for (int j = 0; j < val.length(); j++) {
                    k++;
                    chars[k] = val.charAt(j);
                }
            }
            k++;
            currCount = 1;
            currChar = chars[i];
        }

        // check last case
        chars[k] = currChar;
        if (currCount > 1) {
            String val = Integer.toString(currCount);
            for (int j = 0; j < val.length(); j++) {
                k++;
                chars[k] = val.charAt(j);
            }
        }

        return k + 1;
    }
}
// @lc code=end
