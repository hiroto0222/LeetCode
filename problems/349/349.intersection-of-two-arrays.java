/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        /*
         * return intersection of nums1 and nums2
         * each element must be unique
         *
         * O(N) time, O(N) space
         */

        List<Integer> ans = new ArrayList<>();
        boolean[] seen = new boolean[1001]; // as 0 <= num <= 1000

        // mark seen values from nums1
        for (int num : nums1) {
            if (!seen[num]) {
                seen[num] = true;
            }
        }

        // check against nums2
        for (int num : nums2) {
            if (seen[num]) {
                ans.add(num);
                seen[num] = false; // mark as false to avoid duplicates
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
