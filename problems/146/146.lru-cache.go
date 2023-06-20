/*
 * @lc app=leetcode id=146 lang=golang
 *
 * [146] LRU Cache
 */

package solution

// @lc code=start

// doubly linked list node struct to keep track of key, val, prev, next
// left (dummy) points to LRU, right (dummy) points to MRU
// 1. Get(key):
// 	a) if key DNE -> return -1
// 	b) else -> update node to be MRU
// 2. Put(key, value):
// 	a) if within cap -> add to hashmap, and MRU
// 	b) else -> remove LRU from list and cache

type Node struct {
	key, val   int
	prev, next *Node
}

func NewNode(key, val int) *Node {
	return &Node{
		key:  key,
		val:  val,
		prev: nil,
		next: nil,
	}
}

type LRUCache struct {
	cap         int
	cache       map[int]*Node
	left, right *Node
}

func Constructor(capacity int) LRUCache {
	left, right := NewNode(0, 0), NewNode(0, 0)
	left.next, right.prev = right, left

	return LRUCache{
		cap:   capacity,
		cache: make(map[int]*Node, capacity),
		left:  left,
		right: right,
	}
}

func (this *LRUCache) Remove(node *Node) {
	// remove node
	prev, next := node.prev, node.next
	prev.next, next.prev = next, prev
}

func (this *LRUCache) Insert(node *Node) {
	// insert node to MRU
	prev, next := this.right.prev, this.right
	prev.next = node
	node.prev, node.next = prev, next
}

func (this *LRUCache) Get(key int) int {
	if node, ok := this.cache[key]; ok {
		this.Remove(node)
		this.Insert(node)
		return node.val
	}

	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if node, ok := this.cache[key]; ok {
		this.Remove(node)
	}
	this.cache[key] = NewNode(key, value)
	this.Insert(this.cache[key])

	if len(this.cache) > this.cap {
		// evict LRU from cache and linkedlist
		lru := this.left.next
		this.Remove(lru)
		delete(this.cache, lru.key)
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
// @lc code=end
