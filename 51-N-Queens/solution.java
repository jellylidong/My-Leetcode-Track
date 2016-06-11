public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] col = new int[n]; //col[i] means we put a queen at (i, col[i]);
        place(0, col, ans, n);
        return ans;
    }
    
    
    public void place(int row, int[] col, List<List<String>> ans, int size){
        if(row == size){
            ans.add(col2List(col));
        }
        else{
            for(int i = 0; i < size; i++){
                if(isValid(row, i, col)){
                    col[row] = i;
                    place(row+1, col, ans, size);
                    // col[row] = 0;
                }
            }
        }
    }
    
    public boolean isValid(int row, int i, int[] col){
       for(int row2 = 0; row2 < row; row2++){
            if(col[row2] == i) // in the same col
                return false;
            if(Math.abs(row2-row) == Math.abs(col[row2] - i))
                return false;
       }
       return true;
    }
    
    public List<String> col2List(int[] col){
        List<String> list = new ArrayList<>();
       
        for(int i = 0; i < col.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col.length; j++){
                if(j == col[i])
                    sb.append("Q");
                else
                    sb.append(".");
            }
            list.add(sb.toString());
        }
        
        return list;
    }
}