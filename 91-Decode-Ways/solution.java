public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        dp[0] = (s.charAt(0)-'0') == 0? 0:1;
        dp[1] = dp[0];
        
        int tmp = Integer.parseInt(s.substring(0, 2));
        dp[1] += (tmp >= 10 && tmp <= 26)? 1:0;
        
        for(int i = 2; i < s.length(); i++){
            dp[i] += dp[i-1];
            tmp = Integer.parseInt(s.substring(i-1, i+1));
            dp[i] += (tmp >= 10 && tmp <= 26)? dp[i-2]:0;
        }
        
        return dp[s.length()-1];
    }
}