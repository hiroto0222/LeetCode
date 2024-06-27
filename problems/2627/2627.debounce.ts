/*
 * @lc app=leetcode id=2627 lang=typescript
 *
 * [2627] Debounce
 */

// @lc code=start

type F = (...args: number[]) => void;

/*
A debounced function is a function whose execution time is delayed by t milliseconds.
The execution of such function is also cancelled if it is called again within that window time t.

ie:
if t = 35ms and the function was called at 30ms, 60ms, 100ms:
30ms -> cancelled as 60 - 30 = 30 <= t
60ms -> called at 95ms as 100 - 60 = 40 <= t
100ms -> called at 135ms

intuition:
- using timeout and callback

O(1) time, O(1) space
 */
function debounce(fn: F, t: number): F {
  let timerId: ReturnType<typeof setTimeout>;
  return function (...args) {
    clearTimeout(timerId);
    timerId = setTimeout(() => {
      fn(...args);
    }, t);
  };
}

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */

// @lc code=end
