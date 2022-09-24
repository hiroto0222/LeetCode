import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num1: nums1) {
            for (int num2: nums2) {
                if (map.containsKey(num1 + num2)) {
                    map.put(num1 + num2, map.get(num1 + num2) + 1);
                } else {
                    map.put(num1 + num2, 1);
                }
            }
        }

        for (int num3: nums3) {
            for (int num4: nums4) {
                if (map.containsKey(-(num3 + num4))) {
                    res += map.get(-(num3 + num4));
                }
            }
        }
        
        return res;
    }
}
// @lc code=end

