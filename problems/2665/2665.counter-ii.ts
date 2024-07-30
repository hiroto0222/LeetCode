type Counter = {
  increment: () => number;
  decrement: () => number;
  reset: () => number;
};

/*
 * increment -> increases init by 1 and returns it
 * decrement -> decreases init by 1 and returns it
 * reset -> resets val to init and returns it
 */
function createCounter(init: number): Counter {
  let cnt = init;

  return {
    increment: () => {
      cnt++;
      return cnt;
    },
    decrement: () => {
      cnt--;
      return cnt;
    },
    reset: () => {
      cnt = init;
      return cnt;
    },
  };
}

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
