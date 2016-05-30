public class Solution {
    
   //trick part of this problem, use bit to indicate multi states, when each state has two status 
   //state1 has 0,1, state2 has 0,1 so state1 and state2 can be denote as 11 00 10 01 and so forth
    
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0)
            return;
            
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int lives = lives(board, i, j);
                //current state is live
                if((board[i][j]&1) == 1){
                    if(lives > 3 || lives < 2)
                        board[i][j] |= 0;
                }
                //current state is dead
                else{
                    if(lives >= 3)
                        board[i][j] |= 2;
                }
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] >>= 1;    
            }
        }
    }
    
    public int lives(int[][] board, int i0, int j0){
        int lives = 0;
        for(int i = Math.max(0, i0-1); i <= Math.min(board.length-1, i0+1); i++){
            for(int j = Math.min(0, j0-1); j <= Math.min(board[0].length-1, j0+1); j++){
                if((board[i][j]&1) == 1)
                    lives++;
            }
        }
        
        return lives;
    }
    
   
}