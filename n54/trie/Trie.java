package n54.trie;

public class Trie {


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean has = trie.search("apple");
        trie.search("app");
        boolean startWith = trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }

    private final TrieNode root;

    static class TrieNode {
        boolean isEnd;
        char val;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }

        public TrieNode(char val) {
            this.val = val;
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }

            node = node.children[c - 'a'];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }

        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}
