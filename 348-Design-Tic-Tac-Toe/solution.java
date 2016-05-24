public class TicTacToe {

    int[] col;
    int[] row;
    int diag;
    int adiag;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        col = new int[n];
        row = new int[n];
        diag = 0;
        adiag = 0;
        
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int r, int c, int player) {
        int toAdd = player == 1? 1: -1;
        row[r] += toAdd;
        col[c] += toAdd;
        if(r == c)
            diag += toAdd;
        if(r+c+1 == col.length)
            adiag += toAdd;
            
        int len = col.length;
        if(Math.abs(row[r]) == len || Math.abs(col[c]) == len ||
           Math.abs(diag) == len || Math.abs(adiag) == len)
            return player;
            
        return 0;
    }
    
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */