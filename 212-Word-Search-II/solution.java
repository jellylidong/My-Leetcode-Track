public class Solution {
    HashSet<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length == 0 || board[0].length == 0)
            return new ArrayList<String>();
        
        ans = new HashSet<>();
        TrieNode root = new TrieNode();
        for(String s: words)
            addWord(s, root);
            
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j <board[0].length; j++){
                search(board, i, j, root, "");
            }
        }
        
        return new ArrayList<String>(ans);
    }
    
    public class TrieNode{
        boolean isWord;
        TrieNode[] children;
        
        TrieNode(){
            this.isWord = false;
            children = new TrieNode[26];
        }
        
        TrieNode get(int i){
            return children[i];
        }
    }
    
    public void addWord(String word, TrieNode root){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int id = word.charAt(i) - 'a';
            if(cur.get(id) == null)
                cur.children[id] = new TrieNode();
            cur = cur.get(id);
        }
        cur.isWord = true;
    }
    
    public void search(char[][] board, int i, int j, TrieNode root, String curStr){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if(root.isWord)
            ans.add(curStr);
            
        int id = board[i][j] - 'a';
        if(root.get(id) == null)
            return;
        
        // if(i-1 >= 0)
        //     search(board, i-1, j, root.get(id), curStr + board[i-1][j]);
        // if(i+1 < board.length)
        //     search(board, i+1, j, root.get(id), curStr + board[i+1][j]);
        // if(j-1 >= 0)
        //     search(board, i, j-1, root.get(id), curStr + board[i][j-1]);
        // if(j+1 < board[0].length)
        //     search(board, i, j+1, root.get(id), curStr + board[i][j+1]);
        
        
        search(board, i-1, j, root.get(id), curStr + board[i][j]);
   
        search(board, i+1, j, root.get(id), curStr + board[i][j]);
   
        search(board, i, j-1, root.get(id), curStr + board[i][j]);
  
        search(board, i, j+1, root.get(id), curStr + board[i][j]);
        
        
    }
}