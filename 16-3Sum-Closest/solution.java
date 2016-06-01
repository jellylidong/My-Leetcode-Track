public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sign = 1; //sign of sum - target
        
        
        
        for(int i = 0; i < nums.length; i++){
            int lo = i+1;
            int hi = nums.length-1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                
                if(sum-target > 0){
                    hi--;
                    
                }
                else if(sum - target == 0)
                    return sum;
                else{
                    lo++;
                    
                }
                
                if(diff >= Math.abs(sum - target)){
                    diff = Math.abs(sum - target);
                    sign = sum-target > 0? 1: -1;
                }
                
            }
        }
        
        return sign*diff + target;
    }
}