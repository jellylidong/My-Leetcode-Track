public class Solution {
    
    /*my analysis
* res[j][i] mean the number of sub-sequences of T.substring(0, i) in S.substring(0, j)
* for res[j][0], there's only one solution, that is to delete all char in T
*
* for other res[j][i],
* case 1: S.charAt(j-1) != T.charAt(i-1)
* what we need to do is to ignore the S.charAT(j-1)
* so res[j][i] = 1 * res[j-1][i]
*
* case 2: S.charAt(j-1) == T.charAt(i-1)
* we can also ignore S.charAt(j-1) like case 1,
* so part of res[j][i] would be res[j-1][i]
* we can also ignore both S.charAt(j-1) and T.charAt(i-1) because they are the same
* so the other part wound be res[j-1][i-1]
* so res[j][i] = res[j-1][i] + res[j-1][i-1]
* */
    
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
        
        
        for(int i = 1; i <= lt; i++){
            for(int j = 1; j <= ls; j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return dp[lt][ls];
    }
}