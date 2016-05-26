public class Solution {
    public int maxProduct(int[] nums) {
        int maxHere = nums[0];
        int minHere = nums[0];
        int ans = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int tmp = maxHere;
            maxHere = Math.max(nums[i], Math.max(nums[i]*tmp, nums[i]*minHere));
            minHere = Math.min(nums[i], Math.min(nums[i]*tmp, nums[i]*minHere));
            ans = Math.max(ans, Math.max(maxHere, minHere));
        }
        
        return ans;
    }
}