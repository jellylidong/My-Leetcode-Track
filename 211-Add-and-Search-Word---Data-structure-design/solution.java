public class WordDictionary {
    
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int id = word.charAt(i) - 'a';
            if(cur.get[id] == null)
                cur.get[id] = new TrieNode();
            cur = cur.get[id];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(this.root, word);
    }
    
    public boolean search(TrieNode curRoot, String word){
        TrieNode cur = curRoot;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c != '.'){
                if(cur.get[c-'a'] != null)
                    cur = cur.get[c-'a'];
                else
                    return false;
            }
            else{
                boolean res = false;
                for(int j = 0; j < 26; j++){
                    if(cur.get[j] != null)
                        res = res || search(cur.get[j], word.substring(i+1));
                    if(res == true)
                        return true;
                }
                return res;
            }
        }
        return cur.isWord;
    }
    
    public class TrieNode{
        TrieNode[] get;
        boolean isWord;
        TrieNode(){
            get = new TrieNode[26];
            isWord = false;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");