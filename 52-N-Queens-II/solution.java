public class Solution {
    int ans;
    public int totalNQueens(int n) {
        ans = 0;
        int[] col = new int[n];
        place(0, col);
        
        return ans;
    }
    
    public void place(int row, int[] col){
        if(row == col.length){
            ans++;
            return;
        }
        for(int i = 0; i < col.length; i++){
            if(isValid(row, i, col)){
                col[row] = i;
                place(row+1, col);
            }
        }
    }
    
    public boolean isValid(int row, int newCol, int[] col){
        for(int r = 0; r < row; r++){
            if(col[r] == newCol)
                return false;
            if(Math.abs(row - r) == Math.abs(col[r] - newCol))
                return false;
        }
        return true;
    }
}