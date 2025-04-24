/*
 * @lc app=leetcode id=989 lang=java
 *
 * [989] Add to Array-Form of Integer
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // num = 1321 -> [1,3,2,1]
        // take carry over right to left
        // ie: [2,1,5] 806
        // 811 -> res=[1] k=81
        // 82 -> res=[2,1] k=8
        // 10 -> res=[0,2,1] k=1
        // 1 -> res=[1,0,2,1] k=0

        List<Integer> res = new LinkedList<>();
        int n = num.length;
        for (int i = n - 1; i >= 0; i--) {
            res.add(0, (num[i] + k) % 10);
            k = (num[i] + k) / 10;
        }

        while (k > 0) {
            res.add(0, k % 10);
            k /= 10;
        }
        
        return res;
    }
}
// @lc code=end

