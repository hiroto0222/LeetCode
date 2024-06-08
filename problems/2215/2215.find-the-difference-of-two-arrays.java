/*
 * @lc app=leetcode id=2215 lang=java
 *
 * [2215] Find the Difference of Two Arrays
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        /*
         * return ans where
         * - ans[0] -> all distinct nums in nums1 not present in nums2
         * - ans[1] -> all distinct nums in nums2 not present in nums1
         *
         * intuition:
         * - hashset
         *
         * O(N) time, O(N) space
         */

        List<Integer> diff1 = new ArrayList<>();
        List<Integer> diff2 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
            if (set1.add(num)) {
                diff2.add(num);
            }
        }

        for (int num : nums1) {
            if (set2.add(num)) {
                diff1.add(num);
            }
        }

        return Arrays.asList(diff1, diff2);
    }
}
// @lc code=end
