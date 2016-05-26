public class Solution {
    public int rob(int[] nums) {
        int len = nums.length-1;
        if(len < 0)
            return 0;
        int r1 = helper(nums, 0, len-1);
        int r2 = helper(nums, 1, len);
        
        return Math.max(r1, r2);
    }
    
    public int helper(int[] nums, int lo, int hi){
        if(lo < hi)
            return 0;
        int in = nums[lo];
        int ex = 0;
        
        for(int i = lo; i <= hi; i++){
            int tmp = in;
            in = Math.max(ex+nums[i], in);
            ex = Math.max(ex, tmp);
        }
        
        return Math.max(in, ex);
    }
}