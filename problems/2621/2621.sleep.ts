async function sleep(millis: number): Promise<void> {
  /**
   * need to write an asynchronous function that sleeps for given number of millis and then resolves any value.
   */
  return new Promise<void>((resolve, reject) => {
    if (typeof millis !== "number" || isNaN(millis)) {
      reject(new Error("Invalid argument. Expected a number"));
    } else {
      setTimeout(resolve, millis);
    }
  });
}

/**
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */
