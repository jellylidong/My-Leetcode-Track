public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return s.equals("0")? 0: 1;
        int[] dp = new int[s.length()];
        dp[0] = (s.charAt(0)-'0') == 0? 0:1;
        dp[1] = (s.charAt(1)-'0') == 0? 0:dp[0];
        int tmp = Integer.parseInt(s.substring(0, 2));
        dp[1] += (tmp >= 10 && tmp <= 26)? 1:0;
        
        for(int i = 2; i < s.length(); i++){
            dp[i] += (s.charAt(i)-'0') == 0? 0:dp[i-1];
            tmp = Integer.parseInt(s.substring(i-1, i+1));
            dp[i] += (tmp >= 10 && tmp <= 26)? dp[i-2]:0;
        }
        
        return dp[s.length()-1];
    }
    //don't forget number start with 0, a single 0 has 0 way
    //"10"
}