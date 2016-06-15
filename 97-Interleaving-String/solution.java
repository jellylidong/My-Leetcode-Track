public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //dp[i][j] mean s1.substring(0, i) and s2.substring(0, j) is interleaving string of s3.substring(0, i+j)
        //!!!!
        //that is to say
        //dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1+j) || 
        //           dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 + l2 != s3.length()) return false;
        
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        
        for(int i = 1; i <= l1; i++)
            dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0];
        for(int i = 1; i <= l2; i++)
            dp[0][i] = s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1];
            
        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2; j++){
                dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1+j) || 
                           dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            }
        }
        
        return dp[l1][l2];
    }
}