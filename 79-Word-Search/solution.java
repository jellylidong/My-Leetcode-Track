public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m == 0)
            return false;
        int n = board[0].length;
        if(n == 0)
            return false;
            
        if(word.length() == 0)
            return false;
        
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(search(i, j, visited, board, word, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean search(int i, int j, boolean[][] visited, char[][] board, String word, int p){
        if(p == word.length())
            return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length)
            return false;
        if(visited[i][j])
            return false;
        if(board[i][j] != word.charAt(p))
            return false;
            
        visited[i][j] = true;
        boolean left = search(i, j-1, visited, board, word, p+1);
        boolean right = search(i, j+1, visited, board, word, p+1);
        boolean up = search(i-1, j, visited, board, word, p+1);
        boolean down = search(i+1, j, visited, board, word, p+1);
        visited[i][j] = false;
        
        return left || right || up || down;
    }
}