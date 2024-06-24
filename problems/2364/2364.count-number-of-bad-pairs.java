/*
 * @lc app=leetcode id=2364 lang=java
 *
 * [2364] Count Number of Bad Pairs
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countBadPairs(int[] nums) {
        /*
         * (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i]
         * return total number of bad pairs in nums
         *
         * observation:
         * - for n values, there are (n - 1) + (n - 2) + (n - 3) + ... + 1 pairs
         * - (n-1)(n)/2 number of pairs
         * [1,2,3,4,5] -> 0
         * [6,7,8,9,10] -> 0
         * [1,2,3,5,6] ->
         * - the value does not matter, it is the difference
         * - what is the pattern for a good pair?
         * - rearranging gives nums[i] - i == nums[j] - j for a good pair
         * - we can iterate through nums, where we add to hashmap(nums[i] - i) = [i]
         * - if nums[j] - j exists in hashmap
         * a) as j is larger than all indexs in hashmap(nums[j] - j), we just add the
         * number of new good pairs that can be generated from the addition of the j
         * index
         *
         * ex1:
         * [1,2,3,4,5]
         * i = 0:
         * k = 1 - 0 = 1, cnt = 0, {} -> {1: [0]}
         * i = 1:
         * k = 2 - 1 = 1, cnt = 0, {1: [0]} -> {1: [0,1]}, cnt = cnt + (n - 1) = 1
         * i = 2:
         * k = 3 - 2 = 1, cnt = 1, {1: [0,1]} -> {1: [0,1,2]}, cnt = cnt + (n - 1) = 3
         * i = 3:
         * k = 4 - 3 = 1, cnt = 3, {1: [0,1,2]} -> {1: [0,1,2,3]}, cnt = 3 + 3 = 6
         * i = 4:
         * k = 5 - 4 = 1, cnt = 6, {1: [0,1,2,3]} -> {1: [0,1,2,3,4]}, cnt = 6 + 4 = 10
         * total number of pairs -> n(n-1)/2 = 10
         * 10 - cnt = 0
         *
         * ex2:
         * [4,1,3,3]
         * i = 0:
         * k = 4 - 0 = 4, cnt = 0, {} -> {4: [0]}
         * i = 1:
         * k = 1 - 1 = 0, cnt = 0 -> {4: [0], 0; [1]}
         * i = 2:
         * k = 3 - 2 = 1, cnt = 0 -> {4: [0], 0: [1], 1: [2]}
         * i = 3:
         * k = 3 - 3 = 0, cnt = 0 -> {4: [0], 0: [1,3], 1: [2]}, cnt = 1
         * n(n-1)/2 = 6 - 1 = 5
         *
         * O(N) time, O(N) space
         */

        int n = nums.length;
        Map<Integer, Integer> seen = new HashMap<>();
        long res = (long) n * (n - 1) / 2; // total number of pairs

        for (int i = 0; i < n; i++) {
            int curr = nums[i] - i;
            // if already exists, then add to list of indexes, and subtract the number of
            // additional good pairs
            if (seen.containsKey(curr)) {
                seen.put(curr, seen.get(curr) + 1);
                res -= seen.get(curr) - 1;
            } else {
                seen.put(curr, 1);
            }
        }

        return res;
    }
}
// @lc code=end
