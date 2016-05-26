public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        if(len == 1)
            return nums[0];
            
        int r1 = helper(nums, 0, len-2);
        int r2 = helper(nums, 1, len-1);
        
        return Math.max(r1, r2);
    }
    
    public int helper(int[] nums, int lo, int hi){
        
        int in = nums[lo];
        int ex = 0;
        
        for(int i = lo+1; i <= hi; i++){
            int tmp = in;
            in = Math.max(ex+nums[i], in);
            ex = Math.max(ex, tmp);
        }
        
        return Math.max(in, ex);
    }
}