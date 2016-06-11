public class Solution {
    //hard point: how to handle 0 and number > 26
    
    int ans;
    public int numDecodings(String s) {
        ans = 0;
        if(s.length() == 0)
            return ans;
        int[] dp = new int[s.length()]; //dp[i] means decode ways of s.substring(i);
        
        int len = s.length();
        dp[len-1] = Integer.parseInt(s.substring(len-1, len)) > 0? 1: 0;
        if(len >= 2){
            int n = Integer.parseInt(s.substring(len-2));
            if(n < 10)
                dp[len-2] = 0;
            else if(n <= 26)
                dp[len-2] = 1 + dp[len-1];
            else  if(n%10 != 0)
                dp[len-2] = 1;
            else
                return 0;
            
        }
        
        for(int i = len-3; i >= 0; i--){
            int n = Integer.parseInt(s.substring(i, i+1));
            if(n == 0)
                dp[i] = 0;
            else dp[i] += dp[i+1];
            n = Integer.parseInt(s.substring(i, i+2));
            if(n < 10)
                dp[i] = 0;
            else if(n <= 26)
                dp[i] += dp[i+2];
            else if(n%10 != 0)
                dp[i] = dp[i+1];
            else
                return 0;
        }
        
        return dp[0];
    }
    
   // "230" 
   // "611"
}