public class Solution {
    public void solveSudoku(char[][] board) {
        HashSet[] col = new HashSet[9];
        HashSet[] row = new HashSet[9];
        HashSet[] sqr = new HashSet[9];
        for(int i = 0; i < 9; i++){
            col[i] = new HashSet<Character>();
            row[i] = new HashSet<Character>();
            sqr[i] = new HashSet<Character>();
        }
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c != '.'){
                    col[j].add(c);
                    row[i].add(c);
                    sqr[i/3*3 + j/3].add(c);
                }
            }
        }
        
        helper(board, 0, col, row, sqr);
    }
    
    public boolean helper(char[][] board, int n, HashSet[] col, HashSet[] row, HashSet[] sqr){
        if(n == 81)
            return true;
        else{
            int i = n/9;
            int j = n%9;
            if(board[i][j] != '.')
                return helper(board, n+1, col, row, sqr);
            else{
                for(char c = '1'; c <= '9'; c++){
                    if(!col[j].contains(c) && !row[i].contains(c) && !sqr[i/3*3 + j/3].contains(c)){
                        board[i][j] = c;
                        col[j].add(c);
                        row[i].add(c);
                        sqr[i/3*3+j/3].add(c);
                        if(helper(board, n+1, col, row, sqr))
                            return true;
                        else{
                            board[i][j] = '.';
                            col[j].remove(c);
                            row[i].remove(c);
                            sqr[i/3*3+j/3].remove(c);
                        }
                    }
                }
            }
        }
        return false;
    }
}