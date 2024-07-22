import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        /*
         * return the distinct difference array of nums.
         * diff[i] = distinct(nums[i + 1, n - 1]) - distinct(nums[0, i])
         *
         * intuition:
         * - prefix and suffix arrays for count of distinct elements.
         * - diff[i] = prefix[i] - suffix_distinct(n - 1 -> i + 1)
         *
         * [37,37,37,37,33]
         * [1,1,1,1,2]
         *
         * O(N) time, O(N) space.
         */

        int n = nums.length;
        int[] res = new int[n];

        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            seen.add(nums[i]);
            res[i] = seen.size();
        }

        seen.clear();
        seen.add(nums[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            res[i] = res[i] - seen.size();
            seen.add(nums[i]);
        }

        return res;
    }
}
