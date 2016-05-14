public class Solution {
    public boolean canWinNim(int n) {
        
        if(n <= 3)
            return true;
        if(n == 4)
            return false;
            
        boolean[] dp = new boolean[4];
        dp[0] = dp[1] = dp[2] = true;
        dp[3] = false;
        
        for(int i = 4; i < n; i++){
            boolean dpi = dp[i-1] || dp[i-2] || dp[i-3];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[3];
            dp[3] = dpi;
            
        }
        
        return dp[3];
    }
}