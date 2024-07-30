/*
 * fn(n) = fn(n - 1) + fn(n - 2)
 */
function* fibGenerator(): Generator<number, any, number> {
  let curr = 0;
  let next = 1;

  while (true) {
    yield curr;
    let temp = curr;
    curr = next;
    next = temp + next;
  }
}

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
