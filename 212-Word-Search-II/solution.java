public class Solution {
    HashSet<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length == 0 || board[0].length == 0)
            return new ArrayList<String>();
        
        ans = new HashSet<>();
        TrieNode root = new TrieNode();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(String s: words)
            addWord(s, root);
            
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j <board[0].length; j++){
                // visited[i][j] = true;
                
                search(board, visited, i, j, root);
                // visited[i][j] = false;
            }
        }
        
        return new ArrayList<String>(ans);
    }
    
    public class TrieNode{
        String word;
        TrieNode[] children;
        
        TrieNode(){
            this.word = "";
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
        cur.word = word;
    }
    
    public void search(char[][] board, boolean[][] visited, int i, int j, TrieNode root){
        
        if(root.word.length() != 0){
            ans.add(root.word);
            root.word = ""; //once added, we don't need to add again, so label it as not a word
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
            
        
        
        if(visited[i][j])
            return; 

            
        int id = board[i][j] - 'a';
        if(root.get(id) == null)
            return;
        
        visited[i][j] = true;
        // if(i-1 >= 0)
            search(board, visited, i-1, j, root.get(id));
        // if(i+1 < board.length)
        search(board, visited, i+1, j, root.get(id));
        // if(j-1 >= 0)
            search(board, visited, i, j-1, root.get(id));
        // if(j+1 < board[0].length)
            search(board, visited, i, j+1, root.get(id));
        
        visited[i][j] = false;
    }
    
    /*
    board: ["aaaa","aaaa","aaaa"]
    dictionary: ["aaaaaaaaaaaa","aaaaaaaaaaaaa","aaaaaaaaaaab"]
    
    ["oaan","etae","ihkr","iflv"]
    ["oath","pea","eat","rain"]
    */
}