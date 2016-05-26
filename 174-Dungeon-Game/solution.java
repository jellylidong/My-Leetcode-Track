public class Solution {
    public int calculateMinimumHP(int[][] d) {
        int m = d.length;
        int n = d[0].length;
        
        int[][] ans = new int[m+1][n+1];
        
        //EXCEPT the two right bottom corners
        //ans[m][n-1] = 1;
        //ans[m-1][n] = 1;
        //all other boundary value should be Integer.MAX_VALUE;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++)
                ans[i][j] = Integer.MAX_VALUE;
        }
        
        ans[m][n-1] = 1;
        ans[m-1][n] = 1;
        
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int need = Math.min(ans[i+1][j], ans[i][j+1]) - d[i][j];
                ans[i][j] = need <= 0? 1: need;
            }
        }
        
        return ans[0][0];
    }
}