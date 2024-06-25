/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class TrieNode {
    public TrieNode[] children;
    public boolean endOfWord;

    public TrieNode() {
        this.children = new TrieNode[26]; // 26 letters
        this.endOfWord = false;
    }
}

class Trie {
    /*
     * - trie data structure (prefix tree)
     * - all lower case letters 26
     * - each node represents a letter
     */

    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /*
     * inserts string word into trie
     * O(N) time
     */
    public void insert(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            // if letter does not already exist
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        // update last letter as end of word
        node.endOfWord = true;
    }

    /*
     * returns true if string word is in trie
     * (search("apple") and apple in trie, then true)
     * (search("app") and apple in trie, then false)
     * O(N) time
     */
    public boolean search(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                return false;
            }
            node = node.children[i];
        }

        return node.endOfWord;
    }

    /*
     * returns true if a word starts with prefix
     * O(N) time
     */
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                return false;
            }
            node = node.children[i];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
