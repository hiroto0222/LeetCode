/*
 * @lc app=leetcode id=274 lang=golang
 *
 * [274] H-Index
 */

package solution

// @lc code=start
import (
	"sort"
)

func hIndex(citations []int) int {
	// O(NlogN) time

	n := len(citations)
	sort.Sort(sort.Reverse(sort.IntSlice(citations)))

	for i, val := range citations {
		if val < i+1 {
			return i
		}
	}

	return n
}

// @lc code=end
