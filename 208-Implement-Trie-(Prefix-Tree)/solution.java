class TrieNode {
    // Initialize your data structure here.
    TrieNode[] get;
    boolean isWord;
    public TrieNode() {
        get = new TrieNode[26];
        isWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        char[] cs = word.toCharArray();
        for(int i = 0; i < word.length(); i++){
            int id = cs[i] - 'a';
            if(cur.get[id] == null)
                cur.get[id] = new TrieNode();
            cur = cur.get[id];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        char[] cs = word.toCharArray();
        for(int i = 0; i < word.length(); i++){
            int id = cs[i] - 'a';
            if(cur.get[id] == null){
                System.out.println("here");
                return false;
            }
            cur = cur.get[id];
        }
        //finally, cur become the sub node of last char of word
        
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String pre) {
        TrieNode cur = root;
        char[] cs = pre.toCharArray();
        for(int i = 0; i < pre.length(); i++){
            int id = cs[i] - 'a';
            if(cur.get[id] == null)
                return false;
            cur = cur.get[id];
        }
        
        return true;
            
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");