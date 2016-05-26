public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        int ans = nums[0];
        
        for(int i = 1; i < len; i++){
            sum[i] = Math.max(sum[i-1] + nums[i], nums[i]);
            ans = Math.max(ans, sum[i]);
        }
        
        return ans;
    }
}