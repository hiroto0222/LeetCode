import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        /*
         * for every second:
         * - choose pile with max number of gifts.
         * - leave behind the floor(sqrt(gifts[i]))
         * - return number of left gifts after k seconds
         *
         * intuition:
         * - using maxheap.
         *
         * O(NlogN + KlogN) time, O(N) space.
         */

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        for (int gift : gifts) {
            sum += gift;
            pq.add(gift);
        }

        while (k-- > 0) {
            int max = pq.poll();
            int leftOver = (int) Math.floor(Math.sqrt(max));
            sum -= (max - leftOver);
            if (leftOver > 0) {
                pq.add(leftOver);
            }
        }

        return sum;
    }
}
