public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0 + nums[0];
        for(int i = 1; i <= max && i < nums.length; i++){
            max = Math.max(max, i+nums[i]);
        }
            
        return max >= nums.length-1;
    }
}