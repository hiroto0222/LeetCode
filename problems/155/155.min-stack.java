/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start

import java.util.Stack;

class MinStack {
    /*
     * O(1) time for each function
     *
     * intuition:
     * - stack -> keep track of order of elements and the curr min for each stack
     * position
     */

    private Stack<int[]> stack; // [value, currMin]

    public MinStack() {
        stack = new Stack<>();
    }

    /*
     * pushes element val onto stack
     */
    public void push(int val) {
        int min = val;
        if (!stack.isEmpty()) {
            min = Math.min(stack.peek()[1], min);
        }
        stack.add(new int[] { val, min });
    }

    /*
     * removes the element on the top of the stack
     */
    public void pop() {
        stack.pop();
    }

    /*
     * gets the top element of the stack
     */
    public int top() {
        return stack.peek()[0];
    }

    /*
     * retrieves the minimum element in the stack
     */
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
