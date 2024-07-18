class Solution {
    public int maxSum(int[] nums) {
        /*
         * find the maximum sum of a pair of numbers, such that the largest
         * digit in both numbers are equal.
         * return -1, if no exist.
         *
         * 2 <= n <= 100
         * 1 <= nums[i] <= 10^4
         *
         * intuition:
         * - brute force try every pair as n <= 100, so at most 10000 iterations
         *
         * O(N^2) time, O(1) space.
         */

        int n = nums.length;
        int res = -1;
        for (int i = 0; i < n - 1; i++) {
            int digit1 = getMaxDigit(nums[i]);
            for (int j = i + 1; j < n; j++) {
                int digit2 = getMaxDigit(nums[j]);
                if (digit1 == digit2 && (nums[i] + nums[j] > res)) {
                    res = nums[i] + nums[j];
                }
            }
        }

        return res;
    }

    private int getMaxDigit(int n) {
        int maxDigit = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit > maxDigit) {
                maxDigit = digit;
            }
            n /= 10;
        }

        return maxDigit;
    }
}
