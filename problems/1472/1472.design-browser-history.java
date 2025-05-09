/*
 * @lc app=leetcode id=1472 lang=java
 *
 * [1472] Design Browser History
 */

// @lc code=start

import java.util.Stack;

class BrowserHistory {
    private String home;
    Stack<String> backStack = new Stack<>();
    Stack<String> frontStack = new Stack<>();

    public BrowserHistory(String homepage) {
        home = homepage;
    }
    
    // visits url from current page
    // clears all forward history
    public void visit(String url) {
        backStack.add(url);
        frontStack.clear();
    }
    
    // move steps or max steps back in history
    // return current url
    public String back(int steps) {
        while (steps > 0 && backStack.size() > 0) {
            steps--;
            frontStack.add(backStack.pop());
        }

        return backStack.size() > 0 ? backStack.peek() : home;
    }
    
    // move steps or max forward in history
    // return current url
    public String forward(int steps) {
        while (steps > 0 && frontStack.size() > 0) {
            steps--;
            backStack.add(frontStack.pop());
        }

        return backStack.size() > 0 ? backStack.peek() : home;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
// @lc code=end

