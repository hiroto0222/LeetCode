/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */

// @lc code=start

import java.util.Stack;

class StockSpanner {
    /*
     * span of the stock is the maximum number of consecutive days for which the
     * stock price was less than or equal to the price of that day.
     * ie: [7,2,1,2] and 2 -> 4 days
     *
     * [100,80,60,70,60] 75
     * [(100,1),(80,1),(70,2),(60,1)] 75 -> 4
     * [(100,1),(80,1),(75,4)] 85
     * [(100,1),(85,6)]
     *
     * intuition:
     * - a monotonically decreasing stack
     * - each element in the stack stores the number of consecutive stocks below
     * that price
     * - if a stock is greater than previous, merge such stocks
     */

    // a -> price, b -> count
    record Pair(int a, int b) {
    }

    Stack<Pair> stack;

    public StockSpanner() {
        // monotonically decreasing stack to keep track of consecutive stocks < price
        stack = new Stack<>();
    }

    public int next(int price) {
        int cnt = 1;
        while (!stack.empty() && price >= stack.peek().a) {
            cnt += stack.pop().b;
        }
        stack.add(new Pair(price, cnt));
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end
