public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        
        for(int i = 1; i < len; i++){
            ans[i] = nums[i-1] * ans[i-1];
        }
        //after first round
        //ans[0] = 1;
        //ans[i] = n0*n1*...ni-1
        
        //then we can find ans[len-1] need * 1
        //ans[len-1] need * nums[len-1]
        //ans[len-2] need * nums[len-1]*nums[len-2]
        //...
        //nums[0] need & nums[len-1]*nums[len-2]...*nums[1]
        //so build cur from to 1 to nums[len-1]*nums[len-2]...*nums[1]
        //and multipy backwards
        
        
        int cur = 1;
        for(int i = len-1; i >= 0; i--){
            ans[i] *= cur;
            cur *= nums[i];
        }
        
        return ans;
    }
}