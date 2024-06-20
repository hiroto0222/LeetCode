/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        /*
         * find any peak element
         * must run in logN time
         *
         * [1,2,3,4]
         *
         * intuition:
         * - binary search
         * - if mid > left & mid > right, then peak
         * - if mid < left & mid > right, then check left
         * - if mid > left & mid < right, then check right
         * - if mid < left & mid < right, then check right
         * - if mid = 0 and mid > right, then peak
         * - if mid = n - 1 and mid > left, then peak
         *
         * O(logN) time, O(1) space
         */

        int l = 0;
        int r = nums.length - 1;
        int mid = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int left = mid > 0 ? nums[mid - 1] : -Integer.MAX_VALUE;
            int right = mid < nums.length - 1 ? nums[mid + 1] : -Integer.MAX_VALUE;

            // check for peak, leq to account for max int value
            if (nums[mid] >= left && nums[mid] >= right) {
                break;
            }
            // left ascending slope, so check left side
            else if (nums[mid] <= left && nums[mid] >= right) {
                r = mid - 1;
            }
            // right ascending slope, so check right side
            else if (nums[mid] >= left && nums[mid] <= right) {
                l = mid + 1;
            }
            // else just check right side
            else {
                l = mid + 1;
            }
        }

        return mid;
    }
}
// @lc code=end
