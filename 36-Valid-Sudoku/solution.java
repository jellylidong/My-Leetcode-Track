public class Solution {
    public boolean isValidSudoku(char[][] board) {
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
                    if(col[j].contains(c))
                        return false;
                    else
                        col[j].add(c);
                    if(row[i].contains(c))
                        return false;
                    else
                        row[i].add(c);
                    if(sqr[i/3*3 + j/3].contains(c))
                        return false;
                    else
                        sqr[i/3*3 + j/3].add(c);
                }
            }
        }
        return true;
    }
}