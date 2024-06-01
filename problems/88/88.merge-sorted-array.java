/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 2 pointers
        // i = m - 1, j = n - 1
        // keep track of nums1[k] to replace
        // 0 <= k <= m + n - 1
        // O(N+M) time, O(1) space

        int i = m - 1; // index for nums1
        int j = n - 1; // index for nums2
        int k = m + n - 1;

        // whilst nums2
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i -= 1;
            } else {
                nums1[k] = nums2[j];
                j -= 1;
            }
            k -= 1;
        }
    }
}
// @lc code=end
