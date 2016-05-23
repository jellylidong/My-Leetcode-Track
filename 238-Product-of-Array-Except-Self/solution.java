public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        
        for(int i = 1; i < len; i++){
            ans[i] = nums[i-1] * ans[i-1];
        }
        
        int cur = 1;
        for(int i = len-1; i >= 0; i--){
            ans[i] *= cur;
            cur *= nums[i];
        }
        
        return ans;
    }
}