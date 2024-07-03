/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TimeMap {
    /*
     * time-based key-value data structure.
     * store multiple values for the same key at different time stamps.
     * retrieve the key's value at a certain time stamp.
     *
     * intuition:
     * - {key: [(value, timestamp)]} -> [(value, timestamp)] is strictly increasing
     * by timestamp
     * - set() -> add (value, timestamp) to array
     * - get()
     * - if key does not exist, return empty
     * - else binary search inside values to find largest time within timestamp
     *
     * set() -> O(1) time
     * get() -> O(logN) time
     */

    record TimeMapNode(String value, int timestamp) {
    }

    HashMap<String, List<TimeMapNode>> store;

    public TimeMap() {
        this.store = new HashMap<>();
    }

    /*
     * Stores the key with the value at the given timestamp
     */
    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new ArrayList<>());
        // as calls to set have strictly increasing timestamp, can just append
        store.get(key).add(new TimeMapNode(value, timestamp));
    }

    /*
     * Returns the value for the value associated with the key with largest
     * timestamp_prev <= timestamp.
     * If no values, returns an empty string.
     */
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }

        // binary search largest time stamp such that prevTimestamp <= timestamp
        List<TimeMapNode> curr = store.get(key);
        int l = 0;
        int r = curr.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (curr.get(mid).timestamp > timestamp) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r < 0 ? "" : curr.get(l - 1).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end
