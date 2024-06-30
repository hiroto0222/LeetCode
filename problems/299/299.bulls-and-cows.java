/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String getHint(String secret, String guess) {
        /*
         * number of bulls:
         * digits in the guess that are in the correct position
         * guess = "7810", secret = "1807" then bull is "8" -> 1
         *
         * number of cows:
         * digits in the secret, but wrong position
         * guess = "7810", secret = "1807" then cow is "7","1","0" -> 3
         *
         * intuition:
         * - hashmap of secret {letter -> count}
         * - consider bulls first, then cows
         *
         * O(N) time, O(N) space
         */

        int bulls = 0, cows = 0;
        HashMap<Character, Integer> cnt = new HashMap<>();
        List<Character> rest = new ArrayList<>();

        // populate counts
        for (char c : secret.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }

        // check bulls
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (cnt.containsKey(c) && c == secret.charAt(i)) {
                bulls++;
                if (cnt.get(c) == 1) {
                    cnt.remove(c);
                } else {
                    cnt.put(c, cnt.get(c) - 1);
                }
            } else {
                rest.add(c);
            }
        }

        // check cows
        for (char c : rest) {
            if (cnt.containsKey(c)) {
                cows++;
                if (cnt.get(c) == 1) {
                    cnt.remove(c);
                } else {
                    cnt.put(c, cnt.get(c) - 1);
                }
            }
        }

        return bulls + "A" + cows + "B";
    }
}
// @lc code=end
