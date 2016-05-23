public class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0)
            return 0;
        int[][] ans = new int[costs.length][3];
        ans[0][0] = costs[0][0];
        ans[0][1] = costs[0][1];
        ans[0][2] = costs[0][2];
        
        for(int i = 1; i < costs.length; i++){
            for(int j = 0; j < 3; j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++){
                    if(k != j)
                        min = Math.min(ans[i-1][k], min);
                }
                ans[i][j] = min + costs[i][j];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++)
            min = Math.min(min, ans[costs.length-1][i]);
            
        return min;
    }
}