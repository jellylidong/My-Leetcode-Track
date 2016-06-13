public class Solution {
    public int maxCoins(int[] nums) {
        int[] bs = new int[nums.length+2];
        for(int i = 0; i < nums.length; i++)
            bs[i+1] = nums[i];
        bs[0] = 1;
        bs[nums.length+1] = 1;
        
        int len = bs.length;
        int[][] dp = new int[len][len];
        
       return helper(bs,0, len-1, dp);
    }
    
    public int helper(int[] bs, int lo, int hi, int[][] dp){
        if(lo+1 == hi)
            return 0;
        if(dp[lo][hi] != 0)
            return dp[lo][hi];
        int max = 0;    
        for(int i = lo+1; i <= hi-1; i++){
            max = Math.max(max, bs[lo]*bs[i]*bs[hi] + helper(bs, lo, i, dp) + helper(bs, i, hi, dp));
        }
        
        dp[lo][hi] = max;
        return max;
        
    }
}