public class Solution {
    // int ans;
    // public int longestIncreasingPath(int[][] nums) {
    //     int m = nums.length;
    //     if(m == 0)
    //         return 0;
    //     int n =nums[0].length;
    //     if(n == 0)
    //         return 0;
            
    //     int[][] mem = new int[m][n];
    //     for(int i = 0; i < m; i++){
    //         for(int j = 0; j < n; j++){
    //             mem[i][j] = 1;
    //         }
    //     }
        
    //     ans = mem[0][0];
    //     for(int i = 0; i < m; i++){
    //         for(int j = 0; j < n; j++){
    //             dfs(nums, mem, nums[i][j], mem[i][j], i, j-1);
    //             dfs(nums, mem, nums[i][j], mem[i][j], i, j+1);
    //             dfs(nums, mem, nums[i][j], mem[i][j], i-1, j);
    //             dfs(nums, mem, nums[i][j], mem[i][j], i+1, j);
    //         }
    //     }
        
    //     return ans;
    // }
    
    // public void dfs(int[][] nums, int[][] mem, int preNum, int preStep, int i, int j){
    //     if(i < 0 || i >= nums.length || j < 0 || j >= nums[0].length)
    //         return;
            
    //     if(nums[i][j] >= preNum)
    //         return;
            
    //     if(preStep+1 <= mem[i][j])
    //         return;
        
    //     mem[i][j] = preStep+1;
    //     ans = Math.max(ans, mem[i][j]);
        
    //     dfs(nums, mem, nums[i][j], mem[i][j], i, j-1);
    //     dfs(nums, mem, nums[i][j], mem[i][j], i, j+1);
    //     dfs(nums, mem, nums[i][j], mem[i][j], i-1, j);
    //     dfs(nums, mem, nums[i][j], mem[i][j], i+1, j);

    // }
    
    
    //the above code works fine but slow
    //another memorization: only go deeper when next number > current number
    //mem[i][j] is the max length end with num[i][j], descending order
    // int ans;
    // public int longestIncreasingPath(int[][] nums) {
    //     int m = nums.length;
    //     if(m == 0)
    //         return 0;
    //     int n =nums[0].length;
    //     if(n == 0)
    //         return 0;
            
    //     int[][] mem = new int[m][n];
    //     // for(int i = 0; i < m; i++){
    //     //     for(int j = 0; j < n; j++){
    //     //         mem[i][j] = 1;
    //     //     }
    //     // }
        
    //     ans = 1;
    //     for(int i = 0; i < m; i++){
    //         for(int j = 0; j < n; j++){
    //             dfs(nums, mem, i, j);
    //         }
    //     }
        
    //     return ans;
    // }
    
    // public void dfs(int[][] nums, int[][] mem, int i, int j){
    //     // if(i < 0 || i >= nums.length || j < 0 || j >= nums[0].length)
    //     //     return;
    //     if(mem[i][j] != 0)
    //         return;
            
    //     int len = 1;
    //     if(i-1 >= 0 && nums[i-1][j] > nums[i][j]){
    //         dfs(nums, mem, i-1, j);
    //         len = Math.max(len, 1+mem[i-1][j]);
    //     }
    //     if(i+1 < nums.length && nums[i+1][j] > nums[i][j]){
    //         dfs(nums, mem, i+1, j);
    //         len = Math.max(len, 1+mem[i+1][j]);
    //     }
    //     if(j-1 >= 0 && nums[i][j-1] > nums[i][j]){
    //         dfs(nums, mem, i, j-1);
    //         len = Math.max(len, 1+mem[i][j-1]);
    //     }
    //     if(j+1 < nums[0].length && nums[i][j+1] > nums[i][j]){
    //         dfs(nums, mem, i, j+1);
    //         len = Math.max(len, 1+mem[i][j+1]);
    //     }
        
    //     mem[i][j] = len;
    //     ans = Math.max(len, ans);
    // }
    
    
    //the above two method works well, just another solution
    //the idea is each round we label all node that has bigger number around it as min,
    //the number of round is the longest path
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length, count = m * n, ans = 0;
        while (count > 0) {
            // HashSet<Point> remove = new HashSet<Point>();
            // each round, remove the peak number.
            List<Point> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == Integer.MIN_VALUE)
                        continue;
                    boolean up = (i == 0 || matrix[i][j] >= matrix[i - 1][j]);
                    boolean bottom = (i == n - 1 || matrix[i][j] >= matrix[i + 1][j]);
                    boolean left = (j == 0 || matrix[i][j] >= matrix[i][j - 1]);
                    boolean right = (j == m - 1 || matrix[i][j] >= matrix[i][j + 1]);
                    if (up && bottom && left && right){
                        // count--;
                        // matrix[i][j] = Integer.MIN_VALUE;
                        // remove.add(new Point(i, j));
                        
                        //can not update matrix[i][j] here, it will influence the judges after this number
                        list.add(new Point(i, j));
                    }
                }
            }
            for (Point point : list) {
                matrix[point.x][point.y] = Integer.MIN_VALUE;
                count--;
            }
            ans++;
        }
        return ans;
    }
    
    public static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}