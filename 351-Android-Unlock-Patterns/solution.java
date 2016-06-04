public class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        //skip[i][j] means the number is skipped between i and j
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[7][9] = skip[9][7] = 8;
        skip[3][9] = skip[9][3] = 6;
        skip[1][9] = skip[9][1] =
        skip[2][8] = skip[8][2] =
        skip[6][4] = skip[4][6] =
        skip[3][7] = skip[7][3] = 5;
        
        boolean[] visited = new boolean[10];
        
        int ans = 0;
        for(int i = m; i <= n; i++){
            ans += dfs(1, i-1, visited, skip)*4;
            ans += dfs(2, i-1, visited, skip)*4;
            ans += dfs(5, i-1, visited, skip);
        }
        
        return ans;
    }
    
    //cur is current position
    //remain is how many position remains
    //skip[i][j] = is number between i and j
    public int dfs(int cur, int remain, boolean[] visited, int[][] skip){

        if(remain == 0)
            return 1;
            
        //we must put the visted[i] condition if the for loop, not here
        //becuase if remain == 0 and visited[i], this position should not be count
        //if putting here will count this case
        // if(visited[cur])
        //     return 0;
            
        int ans = 0;
        visited[cur] = true;
        for(int i = 1; i <= 9; i++){
            if(!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]]))
                ans += dfs(i, remain-1, visited, skip);
        }
        
        visited[cur] = false;
        return ans;
        
    }
}