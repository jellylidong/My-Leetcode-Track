public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0)
            return 0;
        int n = grid[0].length;
        if(n == 0)
            return 0;
            
        int[][] ans = new int[m][n];
        ans[0][0] = grid[0][0];
        
        for(int i = 1; i < n; i++)
            ans[0][i] = grid[0][i] + ans[0][i-1];
        for(int i = 1; i < m; i++)
            ans[i][0] = grid[i][0] + ans[i-1][0];
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                ans[i][j] = grid[i][j] + Math.min(ans[i-1][j], ans[i][j-1]);   
            }
        }
        
        return ans[m-1][n-1];
    }
}