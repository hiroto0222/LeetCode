/*
 * @lc app=leetcode id=71 lang=golang
 *
 * [71] Simplify Path
 */

package solution

// @lc code=start
func simplifyPath(path string) string {
	// O(N) time, O(N) space
	// stack to keep track of directories

	path += "/" // to make sure all paths end with /
	n, stack := len(path), make([]string, 0)
	curr := ""

	for i := 0; i < n; i++ {
		c := string(path[i])
		if c == "/" {
			if curr == "" {
				continue
			} else if curr == ".." && len(stack) > 0 {
				stack = stack[:len(stack)-1]
			} else if curr != ".." && curr != "." {
				stack = append(stack, curr)
			}
			curr = ""
		} else {
			curr += c
		}
	}

	if len(stack) == 0 {
		return "/"
	}

	res := ""
	for _, dir := range stack {
		res += "/" + dir
	}

	return res
}

// @lc code=end
