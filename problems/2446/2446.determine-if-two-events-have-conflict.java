/*
 * @lc app=leetcode id=2446 lang=java
 *
 * [2446] Determine if Two Events Have Conflict
 */

// @lc code=start
class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        /*
         * returns true if conflict between event1 and event2.
         * returns false otherwise.
         *
         * if start time of event1/event2 is less than end time of event2/event1
         * then conflict exists.
         */

        int start1 = convertToMinutes(event1[0]);
        int end1 = convertToMinutes(event1[1]);
        int start2 = convertToMinutes(event2[0]);
        int end2 = convertToMinutes(event2[1]);

        return start2 <= end1 && start1 <= end2;
    }

    /*
     * converts HH:MM to minutes
     */
    private int convertToMinutes(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}
// @lc code=end
