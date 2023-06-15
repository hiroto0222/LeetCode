/*
 * @lc app=leetcode id=134 lang=golang
 *
 * [134] Gas Station
 */

package solution

// @lc code=start
func canCompleteCircuit(gas []int, cost []int) int {
	// O(N) time, O(N) space

	n := len(gas)
	gain := make([]int, n)
	curr_sum := 0
	for i := 0; i < n; i++ {
		gain[i] = gas[i] - cost[i]
		curr_sum += gain[i]
	}

	if curr_sum < 0 {
		return -1
	}

	s := 0
	curr_sum = 0
	for i, val := range gain {
		curr_sum += val
		if curr_sum < 0 {
			s = i + 1
			curr_sum = 0
		}
	}

	return s
}

// @lc code=end
