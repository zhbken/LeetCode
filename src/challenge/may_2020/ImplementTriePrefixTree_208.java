package challenge.may_2020;


import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree_208 {

    public void example() {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}

class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.getChildren().containsKey(ch)) {
                node = node.addChild(ch);
            } else {
                node = node.getChildren().get(ch);
            }
        }
        node.setWord(true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node == null || !node.getChildren().containsKey(ch)) {
                return false;
            }
            node = node.getChildren().get(ch);
        }
        return node != null && node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node == null || !node.getChildren().containsKey(ch)) {
                return false;
            }
            node = node.getChildren().get(ch);
        }
        return node != null;
    }

    private class TrieNode {
        private boolean isWord;
        private char c;
        private Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode() {
        }

        public TrieNode(char c) {
            this.c = c;
        }

        public TrieNode addChild(char ch) {
            children.put(ch, new TrieNode(ch));
            return children.get(ch);
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, TrieNode> children) {
            this.children = children;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */