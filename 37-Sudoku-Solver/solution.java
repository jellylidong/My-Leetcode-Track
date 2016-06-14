public class Solution {
    HashSet[] col;
    HashSet[] row;
    HashSet[] sqr;
    public void solveSudoku(char[][] board) {
        int len = board.length;
        col = new HashSet[len];
        row = new HashSet[len];
        sqr = new HashSet[len];
        for(int i = 0; i < len; i++){
            col[i] = new HashSet<Character>();
            row[i] = new HashSet<Character>();
            sqr[i] = new HashSet<Character>();
        }
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                char c = board[i][j];
                if(c != '.' ){
                    row[i].add(c);
                    col[j].add(c);
                    sqr[i/3*3+j/3].add(c);
                }
            }
        }
        
        solve(board, 0, 0);
    }
    
    public boolean solve(char[][] board, int r, int c){
        if(r == board.length)
            return true;
        
        char ch = board[r][c];
        if(ch != '.'){
            // row[r].add(ch);
            // col[c].add(ch);
            // sqr[r/3*3+c/3].add(ch);
            if(c == board[0].length-1)
                return solve(board, r+1, 0);
            else
                return solve(board, r, c+1);
        }
        else{
            for(char cc = '1'; cc <= '9'; cc++){
                if(!row[r].contains(cc) && !col[c].contains(cc) && !sqr[r/3*3+c/3].contains(cc)){
                    row[r].add(cc);
                    col[c].add(cc);
                    sqr[r/3*3+c/3].add(cc);
                    board[r][c] = cc;
                    boolean res = false;
                    if(c == board[0].length-1)
                        res = solve(board, r+1, 0);
                    else
                        res = solve(board, r, c+1);
                    if(res == true)
                        return true;
                    else{
                        row[r].remove(cc);
                        col[c].remove(cc);
                        sqr[r/3*3+c/3].remove(cc);
                        board[r][c] = '.';
                        res = false;
                    }
                }
            }
        }
        
        return false;
    }
}