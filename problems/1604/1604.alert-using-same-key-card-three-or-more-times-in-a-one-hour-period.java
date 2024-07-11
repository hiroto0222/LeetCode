/*
 * @lc app=leetcode id=1604 lang=java
 *
 * [1604] Alert Using Same Key-Card Three or More Times in a One Hour Period
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        /*
         * return list of unique worker names who recieved an alert.
         * sort such names in ascending order.
         * alert is given if a worker uses keycard 3 or more times in one hour.
         * (10:00, 11:00) is considered within 1 hour.
         * (22:51, 23:52) is not.
         *
         * intuition:
         * - group by name and sort by time.
         * - for each name, check alert condition.
         *
         * O(NlogN) time, O(N) space.
         */

        int n = keyName.length;
        Map<String, List<String>> workers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            workers.putIfAbsent(keyName[i], new ArrayList<>());
            workers.get(keyName[i]).add(keyTime[i]);
        }

        List<String> res = new ArrayList<>();
        for (String name : workers.keySet()) {
            List<String> times = workers.get(name);
            Collections.sort(times);

            for (int i = 0; i < times.size() - 2; i++) {
                // if the 1st and 3rd time have a diff of <= 60, then alert
                if (checkDiff(times.get(i), times.get(i + 2)) <= 60) {
                    res.add(name);
                    break;
                }
            }
        }

        Collections.sort(res);
        return res;
    }

    // calculates the difference in minutes of time1 to time2 (time2 - time1)
    private int checkDiff(String time1, String time2) {
        int hours1 = Integer.parseInt(time1.substring(0, 2));
        int minutes1 = Integer.parseInt(time1.substring(3, 5));
        int hours2 = Integer.parseInt(time2.substring(0, 2));
        int minutes2 = Integer.parseInt(time2.substring(3, 5));

        return (hours2 * 60 + minutes2) - (hours1 * 60 + minutes1);
    }
}
// @lc code=end
