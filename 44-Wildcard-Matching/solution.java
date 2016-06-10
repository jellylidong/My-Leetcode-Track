public class Solution {
    public boolean isMatch(String s, String p) {
        int lo = 0;
        while(p.charAt(lo) == '*' && lo < p.length())
            lo++;
        lo = lo==0? lo : lo-1;
        
        int hi = p.length()-1;
        while(p.charAt(hi) == '*' && hi > lo)
            hi--;
            
        p = p.substring(lo, hi+1);
        
        int ls = s.length();
        int lp = p.length();
        
        boolean[][] dp = new boolean[ls+1][lp+1];
        dp[ls][lp] = true; // empty matches empty
        //do[i][j] means s.substring(i, ls) matches p.substring(j, lp);
        
        for(int i = ls-1; i >= 0; i--){
            for(int j = lp-1; j >= 0; j--){
                if(s.charAt(i) == p.charAt(j))
                    dp[i][j] = dp[i+1][j+1];
                else if(p.charAt(j) == '?')
                    dp[i][j] = dp[i+1][j+1];
                else{//p.charAt(j) == '*'
                    dp[i][j] = dp[i+1][j] 
                            // if "XXX" matches "*XXX",  then "XXXX" also matches "*XXX",
                            // *'s sequence add another char
                            || dp[i][j+1];
                            //if current s "XXX" match current p "XXX"
                            //then p becomes "*XXX", let * work as empty string, then s "XXX" matches p "*XXX"
                }
            }
        }
        
        return dp[0][0];
        
    }
}