/*
 * @lc app=leetcode id=1207 lang=java
 *
 * [1207] Unique Number of Occurrences
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        /*
         * return true if number of occurences of each val in array is unique
         * [1,2,2,1,1,3] -> 1x3, 2x2, 3x1 so unique
         *
         * intuition:
         * - hashmap to keep track of occurences
         * - hashset to keep track of unique occurences
         *
         * O(N) time, O(N) space
         */

        Map<Integer, Integer> occurences = new HashMap<>();
        for (int val : arr) {
            occurences.put(val, occurences.getOrDefault(val, 0) + 1);
        }

        Set<Integer> unique = new HashSet<>(occurences.values());

        return unique.size() == occurences.size();
    }
}
// @lc code=end
