### 题目描述
https://leetcode.cn/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路
前缀树是一种多叉树，用于高效存储和检索字符串集合设计。核心思想是空间换时间
通过共享字符串的公共前缀来减少重复比较。

核心特性：
1.节点结构： 每个节点代表一个字符，根节点为空，路径上的字符连接成完整字符串。
2.共享前缀：具有相同前缀的字符串不用重复存储
3.动态查询：支持实时前缀匹配

节点组成
```java
 static class TrieNode {
    boolean isEnd;
    char val;
    TrieNode[] children;
}
```

代码：
```java
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

```