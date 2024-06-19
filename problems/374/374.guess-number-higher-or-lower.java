/*
 * @lc app=leetcode id=374 lang=java
 *
 * [374] Guess Number Higher or Lower
 */

// @lc code=start
/**
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */

class Solution extends GuessGame {
    public int guessNumber(int n) {
        /*
         * guess picked number from 1 to n
         *
         * intuition:
         * - binary search
         * - call guess() with (1 + n) / 2
         *
         * O(logN) time, O(1) space
         */

        int l = 1;
        int r = n;
        int mid;
        while (true) {
            // avoid overflow of l + r
            mid = l + (r - l) / 2;
            int res = guess(mid);
            // mid > pick
            if (res == -1) {
                r = mid - 1;
            }
            // mid < pick
            else if (res == 1) {
                l = mid + 1;
            }
            // mid == pick
            else {
                break;
            }
        }

        return mid;
    }
}
// @lc code=end
