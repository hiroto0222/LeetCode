/*
 * @lc app=leetcode id=819 lang=java
 *
 * [819] Most Common Word
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // return most frequent word that is not banned
        // guaranteed atleast one word is not banned and unque
        // word is case-insensitive and no punctuations
        // "abc." -> word is "a"

        String[] words = paragraph.toLowerCase().split("[^a-z]+");
        HashMap<String, Integer> cnt = new HashMap<>();
        HashSet<String> bannedWords = new HashSet<>(Arrays.asList(banned));

        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        int currMax = 0;
        String res = "";
        for (String word : words) {
            if (!bannedWords.contains(word) && cnt.get(word) > currMax) {
                currMax = cnt.get(word);
                res = word;
            }
        }

        return res;
    }
}
// @lc code=end

