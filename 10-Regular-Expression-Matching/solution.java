public class Solution {
    public boolean isMatch(String s, String p) {
        //first we need to understand why isMatch("ab", ".*") → true
        //obviously the "." here works as "."
        //"*" Matches zero or more of the preceding element,
        //note here, it says element, not char
        //so here "*" can work as another ".", then this "." works as "b"
        //note the "*" must have something before it, a string starts with "*" is an invalid pattern
        
        int ls = s.length();
        int lp = p.length();
        
        boolean[][] dp = new boolean[ls+1][lp+1];
        dp[0][0] = true;
        //dp[i][j] mean if s.substring(0, i) matches p.substring(0, j)
        
        //non-empty string don't match ""
        for(int i = 0; i < ls; i++)
            dp[i+1][0] = false;
        //if an empty string can match an non-empty p
        //p can only in format like: a*b**c***.***, ie repeating of a char or . followed by one or more *
        //i > 0 && p.charAt(i) == '*' makes sure the * is not at the begining of p
        // also if we meet a "*" in p, assume the char before * is a,
        //then to macth "" with XXXXa*, it means * works as 0 preceding, so the match value should be dp[0][i-2]
        for(int i = 0; i < lp; i++)
            dp[0][i+1] = i>0 && p.charAt(i) == '*' && dp[0][i-1];
            
        for(int i = 1; i <=ls; i++){
            for(int j = 1; j <= lp; j++){
                if(p.charAt(j-1) != '*'){
                    dp[i][j] = (dp[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1)) || // two char are the same
                               (dp[i-1][j-1] && p.charAt(j-1) == '.'); // "." works as s.charAt(i-1)
                }
                else{
                    dp[i][j] =  dp[i][j-2] || // "*" work as 0 proceedings with it previous one char
                               (dp[i-1][j] && p.charAt(j-1-1) == '.') ||
                               //for example
                               //s = ####X
                               //p = ########*
                               //dp[i-1][j] means #### matches ########*
                               //if ####x also matches ########*, ########* can only be #######.* or #######X*
                               //that is to say, * works as two . here, the second , is used to match x
                               (dp[i-1][j] && p.charAt(j-1-1) == s.charAt(i-1));
                }
            }
        }
        
        return dp[ls][lp];
    }
}