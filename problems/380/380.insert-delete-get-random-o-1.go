/*
 * @lc app=leetcode id=380 lang=golang
 *
 * [380] Insert Delete GetRandom O(1)
 */

package solution

// @lc code=start
import "math/rand"

type RandomizedSet struct {
	vals map[int]int
	data []int
}

func Constructor() RandomizedSet {
	vals := make(map[int]int)
	data := make([]int, 0)
	return RandomizedSet{vals, data}
}

func (this *RandomizedSet) Insert(val int) bool {
	if _, ok := this.vals[val]; ok {
		return false
	}

	this.vals[val] = len(this.data)
	this.data = append(this.data, val)
	return true
}

func (this *RandomizedSet) Remove(val int) bool {
	if _, ok := this.vals[val]; !ok {
		return false
	}

	last_ele_idx := len(this.data) - 1
	last_ele := this.data[last_ele_idx]
	curr_ele_idx := this.vals[val]

	// swap idx
	this.vals[last_ele] = curr_ele_idx
	this.data[curr_ele_idx], this.data[last_ele_idx] = this.data[last_ele_idx], this.data[curr_ele_idx]

	// remove
	delete(this.vals, val)
	this.data = this.data[:last_ele_idx]

	return true
}

func (this *RandomizedSet) GetRandom() int {
	rand_idx := rand.Intn(len(this.data))
	return this.data[rand_idx]
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */
// @lc code=end
