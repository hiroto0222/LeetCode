/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // k people in front who have height >= h
        // people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        // [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        // 
        // the shortest person is always at pos k with k people in front
        // the 2nd shortest person would be infront of shortest, with k people in front
        // O(N^2)
        // people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        // people = [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
        // sort by descending h, then ascending k
        // greedily insert people at kth position
        
        int n = people.length;
        Arrays.sort(people, (a, b) -> {
            return (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0];
        });
        
        List<int[]> res = new ArrayList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }

        return res.toArray(new int[n][]);
    }
}
// @lc code=end

