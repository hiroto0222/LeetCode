type ToBeOrNotToBe = {
  toBe: (val: any) => boolean;
  notToBe: (val: any) => boolean;
};

/*
 * toBe returns true if val === valToTest
 * notToBe returns true if val !== valToTest
 */
function expect(val: any): ToBeOrNotToBe {
  const throwError = (msg: string) => {
    throw new Error(msg);
  };

  return {
    toBe: function (valToTest) {
      return val === valToTest || throwError("Not Equal");
    },
    notToBe: function (valToTest) {
      return val !== valToTest || throwError("Equal");
    },
  };
}

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */
