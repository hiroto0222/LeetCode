class Solution {
    public String sortSentence(String s) {
        /*
         * Given a shuffled sentence s containing no more than 9 words,
         * reconstruct and return the original sentence.
         * 
         * intuition:
         * - all words are space seperated, with 1-indexed word pos appended at the end.
         * - split s and sort them accordingly.
         * - join at the end.
         * 
         * O(N) time, O(N) space
         */

        String[] words = s.split(" ");
        String[] res = new String[words.length];
        for (String word : words) {
            int i = Character.getNumericValue(word.charAt(word.length() - 1)) - 1;
            res[i] = word.substring(0, word.length() - 1);
        }

        return String.join(" ", res);
    }
}