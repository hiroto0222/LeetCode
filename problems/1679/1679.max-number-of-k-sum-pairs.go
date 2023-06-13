/*
 * @lc app=leetcode id=1679 lang=golang
 *
 * [1679] Max Number of K-Sum Pairs
 */

package solution

// @lc code=start
func maxOperations(nums []int, k int) int {
	// O(N) time, O(N) space

	dict := make(map[int]int)
	res := 0

	for _, val := range nums {
		if cnt, ok := dict[val]; ok {
			res += 1
			if cnt > 1 {
				dict[val] -= 1
			} else {
				delete(dict, val)
			}
		} else {
			dict[k-val]++
		}
	}

	return res
}

// @lc code=end
