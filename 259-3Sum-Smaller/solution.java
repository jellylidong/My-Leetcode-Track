public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int lo = i+1;
            int hi = nums.length-1;
            while(lo < hi){
                if(nums[i] + nums[lo] + nums[hi] < target){
                    count += hi-lo; // nums[i] + nums[lo] + any nums[lo+1 ... hi]
                    lo++;
                }
                else
                    hi--;
            }
            
        }
        return count;
    }
}