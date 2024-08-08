type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | Array<JSONValue>;

/**
 * return chunked array of original arr.
 * - contains original elements, but subarrays of each of length of size.
 * - last subarray <= size if not evenly divisble.
 */
function chunk(arr: Obj[], size: number): Obj[][] {
    const res: Obj[][] = [];
    let curr: Obj[] = [];

    arr.forEach((val, _) => {
        curr.push(val);
        if (curr.length == size) {
            res.push(curr);
            curr = [];
        }
    })

    if (curr.length > 0) {
        res.push(curr);
    }

    return res;
};
