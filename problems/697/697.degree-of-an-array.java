/*
 * @lc app=leetcode id=697 lang=java
 *
 * [697] Degree of an Array
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        /*
         * find the smallest possible length of a contiguous subarray of nums that has
         * same degree as nums. degree is the max freq of any one of its elements.
         *
         * intuition:
         * - hashmap of {nums[i]: [cnt, start, end]}
         * - while populating hashmap, keep track of max count.
         * - iterate again against all nums[i] that have max count (degree)
         * - find the min (end - start) length.
         *
         * O(N) time, O(N) space.
         */

        int n = nums.length;
        Map<Integer, int[]> memo = new HashMap<>();

        // populate hashmap and find degree.
        int degree = 1;
        for (int i = 0; i < n; i++) {
            if (!memo.containsKey(nums[i])) {
                memo.put(nums[i], new int[] { 1, i, i });
            } else {
                int[] tmp = memo.get(nums[i]);
                tmp[0] += 1;
                tmp[2] = i;
                memo.put(nums[i], tmp);
            }

            if (memo.get(nums[i])[0] > degree) {
                degree = memo.get(nums[i])[0];
            }
        }

        int res = 50001;
        for (int[] vals : memo.values()) {
            if (vals[0] == degree) {
                int len = vals[2] - vals[1] + 1;
                if (len < res) {
                    res = len;
                }
            }
        }

        return res;
    }
}
// @lc code=end
