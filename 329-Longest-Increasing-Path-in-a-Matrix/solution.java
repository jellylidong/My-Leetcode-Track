public class Solution {
    int ans;
    public int longestIncreasingPath(int[][] nums) {
        int m = nums.length;
        if(m == 0)
            return 0;
        int n =nums[0].length;
        if(n == 0)
            return 0;
            
        int[][] mem = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                mem[i][j] = 1;
            }
        }
        
        ans = mem[0][0];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(nums, mem, nums[i][j], mem[i][j], i, j-1);
                dfs(nums, mem, nums[i][j], mem[i][j], i, j+1);
                dfs(nums, mem, nums[i][j], mem[i][j], i-1, j);
                dfs(nums, mem, nums[i][j], mem[i][j], i+1, j);
            }
        }
        
        return ans;
    }
    
    public void dfs(int[][] nums, int[][] mem, int preNum, int preStep, int i, int j){
        if(i < 0 || i >= nums.length || j < 0 || j >= nums[0].length)
            return;
            
        if(nums[i][j] >= preNum)
            return;
            
        if(preStep+1 <= mem[i][j])
            return;
        
        mem[i][j] = preStep+1;
        ans = Math.max(ans, mem[i][j]);
        
        dfs(nums, mem, nums[i][j], mem[i][j], i, j-1);
        dfs(nums, mem, nums[i][j], mem[i][j], i, j+1);
        dfs(nums, mem, nums[i][j], mem[i][j], i-1, j);
        dfs(nums, mem, nums[i][j], mem[i][j], i+1, j);

    }
}