public class Solution {
    
    // //method1
    // boolean[] zA;
    // boolean[] zB;
    // public int[][] multiply(int[][] A, int[][] B) {
    //     int m = A.length;
    //     int l = B[0].length;
        
    //     zA = new boolean[m];
    //     zB = new boolean[l];
        
    //     int[][] ans = new int[m][l];
        
    //     for(int i = 0; i < m; i++){
    //         for(int j = 0; j < l; j++){
    //             ans[i][j] = mult(A, i, B, j);
    //         }
    //     }
        
    //     return ans;
    // }
    
    // public int mult(int[][] A, int ra, int[][] B, int lb){
    //     if(zA[ra] || zB[lb]) //to save time, if the whole row of A is 0 or the whole column is 0, skip it
    //         return 0;
    
    //     int countA = 0;
    //     int countB = 0;
        
    //     int ans = 0;
    //     for(int i = 0; i < A[ra].length; i++){
    //         ans += A[ra][i] * B[i][lb];
    //         if(A[ra][i] == 0)
    //             countA++;
    //         if(B[i][lb] == 0)
    //             countB++;
    //     }
        
    //     if(countA == A[ra].length)
    //         zA[ra] = true;
    //     if(countB == B.length)
    //         zB[lb] = true;
        
    //     return ans;
    // }
    
    //method 2
    // ans[i][k] += A[i][j] * B[j][k];
    //where i is the ith row of A, j  is j the col of A, k is kth col of B
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int l = B[0].length;
        int[][] ans = new int[m][l];
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                //very import to save time
                if(A[i][j] != 0){
                    for(int k = 0; k < B[0].length; k++){
                        ans[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        
        return ans;
    }
}