public class Solution {
    public boolean isMatch(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        
        boolean[][] dp = new boolean[ls+1][lp+1]; //dp[i][j] s.substring(0, i) macthes p.substring(0, j)
        dp[0][0] = true;
        
        for(int i = 1; i <= lp; i++)
            dp[0][i] = i > 1 && dp[0][i-2] && p.charAt(i-1) == '*';
        for(int i = 1; i <= ls; i++)
            dp[i][0] = false;
            
        for(int i = 1; i <= ls; i++){
            for(int j = 1; j <= lp; j++){
                if(p.charAt(j-1) != '*')
                    dp[i][j] = dp[i-1][j-1] && (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1));
                else{
                    dp[i][j] = dp[i][j-2] ||
                               (dp[i-1][j] && (p.charAt(j-1-1) == '.' || p.charAt(j-1-1) == s.charAt(i-1)));
                }
            }
        }
        
        return dp[ls][lp];
    }
}