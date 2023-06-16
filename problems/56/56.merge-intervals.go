/*
 * @lc app=leetcode id=56 lang=golang
 *
 * [56] Merge Intervals
 */

package solution

import "sort"

// @lc code=start
func merge(intervals [][]int) [][]int {
	// compare prev end to curr start
	// if curr start <= prev end, prev end = max(prev end, curr end)
	// for case: [[1,5],[2,4]]
	// O(NlogN) time, O(N) space

	// sort in ascending order by start time
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	n := len(intervals)
	res := make([][]int, 1)
	res[0] = intervals[0]

	for i := 1; i < n; i++ {
		curr := intervals[i]
		if curr[0] <= res[len(res)-1][1] {
			res[len(res)-1][1] = max(res[len(res)-1][1], curr[1])
		} else {
			res = append(res, curr)
		}
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end
