public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        int ans = 0;
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                if(i == j)
                    dp[j] = nums[i];
                else
                    dp[j] = dp[j-1] + nums[j];
                    
                if(dp[j] == k)
                    ans = Math.max(ans, j-i);
            }
        }
        
        return ans;
    }
    
    
}