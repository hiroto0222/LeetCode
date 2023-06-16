/*
 * @lc app=leetcode id=219 lang=golang
 *
 * [219] Contains Duplicate II
 */

package solution

// @lc code=start
func containsNearbyDuplicate(nums []int, k int) bool {
	// are there 2 distinct i, j such that
	// nums[i] == nums[j] and abs(i - j) <= k
	// keep track of most recent idx for each val
	// if the curr ele exists in hashmap and abs(map[nums[i]] - i) <= k, then true
	// O(N) time, O(N) space

	hash := make(map[int]int)
	for i, val := range nums {
		if prev_i, ok := hash[val]; ok && abs(prev_i, i) <= k {
			return true
		}

		hash[val] = i
	}

	return false
}

func abs(a, b int) int {
	if a > b {
		b, a = a, b
	}

	return b - a
}

// @lc code=end
