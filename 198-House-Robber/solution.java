public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        if(len == 1)
            return nums[0];
        if(len == 2)
            return Math.max(nums[0], nums[1]);
        int[][] dp = new int[2][len];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        dp[0][1] = Math.max(dp[0][0], dp[1][0]);
        dp[1][1] = nums[1];
        
        for(int i = 2; i < len; i++){
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
            dp[1][i] = nums[i] + Math.max(dp[0][i-2], dp[1][i-2]);
        }
        
        return Math.max(dp[0][len-1], dp[1][len-1]);
    
    }
}