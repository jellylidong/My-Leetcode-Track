public class Solution {
    
    //when you redo it, try to use union find, it's much better
    //https://leetcode.com/discuss/79537/java-union-find-solution
    
    int count;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0)
            return 0;
        int n = grid[0].length;
        if(n == 0)
            return 0;
            
        boolean[][] visited = new boolean[m][n];
        
        count = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1')
                    count++;
                dfs(grid, i, j, visited);
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j, boolean[][] visited){
        if(visited[i][j])
            return;
        if(grid[i][j] == '0')
            return;
        
        visited[i][j] = true;
        if(i-1 >= 0) dfs(grid, i-1, j, visited);
        if(i+1 < grid.length)   dfs(grid, i+1, j, visited);
        if(j-1 >= 0) dfs(grid, i, j-1, visited);
        if(j+1 < grid[0].length) dfs(grid, i, j+1, visited);
    }
}