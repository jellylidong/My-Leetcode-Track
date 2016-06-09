public class Solution {
    public int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        
        if(lt > ls)
            return 0;
        if(lt == 0 && lt == ls)
            return 1;
            
        int[][] dp = new int[lt+1][ls+1]; 
        // dp[i][j] means how many subsequences in s.substring(0, j) for t.substring(0, i)
        for(int i = 0; i <= ls; i++)
            dp[0][i] = 1;
        
        
        for(int i = 0; i < lt; i++){
            for(int j = 0; j < ls; j++){
                if(t.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i][j-1];
                }
                else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }
            }
        }
        
        return dp[lt][ls];
    }
}