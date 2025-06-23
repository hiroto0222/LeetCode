/*
 * @lc app=leetcode id=1769 lang=java
 *
 * [1769] Minimum Number of Operations to Move All Balls to Each Box
 */

// @lc code=start
class Solution {
    public int[] minOperations(String boxes) {
        // count number of operations by iterating forward and backwards
        // keep track of counts of "1" seen
        // then forward[i] = forward[prev] + count
        // answer = forward + backward
        // "110" -> forward = [0, 1, 3]
        //       -> backward = [1, 0, 0]
        // O(N) time, O(N) space
        
        int n = boxes.length();
        int[] res = new int[n];
        
        int cnt = 0;
        int prefix = 0;
        for (int i = 0; i < n; i++) {
            res[i] = prefix + cnt;
            if (boxes.charAt(i) == '1') {
                cnt++;
            }
            prefix = res[i];
        }

        cnt = 0;
        int suffix = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curr = suffix + cnt;
            res[i] += curr;
            if (boxes.charAt(i) == '1') {
                cnt++;
            }
            suffix = curr;
        }

        return res;
    }
}
// @lc code=end

