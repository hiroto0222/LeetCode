/*
 * @lc app=leetcode id=2215 lang=golang
 *
 * [2215] Find the Difference of Two Arrays
 */

package solution

// @lc code=start
func findDifference(nums1 []int, nums2 []int) [][]int {
	s1 := make(map[int]bool)
	s2 := make(map[int]bool)
	answer := make([][]int, 2)

	for _, v := range nums1 {
		s1[v] = true
	}
	for _, v := range nums2 {
		s2[v] = true
	}

	for v := range s1 {
		if _, ok := s2[v]; !ok {
			answer[0] = append(answer[0], v)
		}
	}
	for v := range s2 {
		if _, ok := s1[v]; !ok {
			answer[1] = append(answer[1], v)
		}
	}

	return answer
}

// @lc code=end
