type Fn = (...params: number[]) => number;

/*
 * a memoized function is a function that will never be called twice with the same arguments, instead returns cached answer.
 * 3 possible funcs:
 * - sum(a, b) -> a + b
 * - fib(n) -> fib(n - 1) + fib(n - 2)
 * - factorial(n) -> factorial(n - 1) * n
 */
function memoize(fn: Fn): Fn {
  const cache = new Map<string, number>();

  return function (...args) {
    const key = JSON.stringify(args);

    if (cache.has(key)) {
      return cache.get(key)!;
    }

    const res = fn(...args);
    cache.set(key, res);

    return res;
  };
}

/**
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1
 */
