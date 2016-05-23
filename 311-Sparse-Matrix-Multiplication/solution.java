public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int l = B[0].length;
        int[][] ans = new int[m][l];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < l; j++){
                ans[i][j] = mult(A, i, B, j);
            }
        }
        
        return ans;
    }
    
    public int mult(int[][] A, int ra, int[][] B, int lb){
        int ans = 0;
        for(int i = 0; i < A[ra].length; i++){
            ans += A[ra][i] * B[i][lb];
        }
        
        return ans;
    }
}