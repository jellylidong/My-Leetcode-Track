public class Solution {
    
    //current status only uses one bit, we can use its other bit to indicate other state
    //for example, in this problem, most right bit is current state, then 2nd right bit is next state, 
    //and so forth
    
    public void gameOfLife(int[][] board) {
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                int l = lives(board, i, j);
                if((board[i][j]&1) == 1){
                    if(l < 2) board[i][j] &= 1;
                    else if(l==2 || l==3) board[i][j] |= 2;
                    else if(l > 3)  board[i][j] &= 1;
                }
                else{
                    if(l == 3)
                        board[i][j] |= 2;
                }
            }
        }
        
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                board[i][j] >>= 1;
            }
        }
    }
    
    public int lives(int[][] board, int i0, int j0){
        int res = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(i0+i >= 0 && i0+i < board.length && j0+j >= 0 && j0+j < board[0].length){
                    if((board[i0+i][j0+j]&1) == 1)
                        res++;
                }
            }
        }
        
        if((board[i0][j0]&1) == 1)
            res--;
            
        return res;
    }
    
}