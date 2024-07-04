/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start

import java.util.Stack;

class MyQueue {
    /*
     * intuition:
     * - stack1 is used to keep pushing elements
     * - when pop or peek is called, we check stack2
     * - if stack2 is empty, then transfer all elements from stack1 to stack2
     * - if both stack1 and stack2 are empty, then it is empty
     *
     * push() -> O(1) time
     * pop() -> O(1) amortized time
     * peek() -> O(1) amortized time
     * empty() -> O(1) time
     */

    Stack<Integer> stack1; // handles pushing to the stack
    Stack<Integer> stack2; // handles popping/peeking from the stack

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
