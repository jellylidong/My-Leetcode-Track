public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0 + nums[0];
        for(int i = 1; i <= max && i < nums.length; i++){
            max = Math.max(max, i+nums[i]);
            //early termination to avoid TLE
            if(max >= nums.length-1)
                return true;
        }
            
        return max >= nums.length-1;
    }
}