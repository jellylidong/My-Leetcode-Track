public class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        
        //word1 -> word2
        int[][] dp = new int[l1+1][l2+1];
        
        for(int i = 0; i <= l2; i++)
            dp[0][i] = i;
        for(int i = 0; i <= l1; i++)
            dp[i][0] = i;
            
        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2; j++){
                int insert = dp[i-1][j] + 1;
                int delete = dp[i][j-1] + 1;
                int replace = dp[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1)? 0: 1); 
                // the cond? val1: val2 must be in brackets, or can return wrong value, but why???????
                
                dp[i][j] = Math.min(replace, Math.min(insert, delete));
            }
        }
        
        return dp[l1][l2];
    }
}