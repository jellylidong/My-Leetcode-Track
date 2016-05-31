public class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi){
            int mid = (hi-lo)/2;
            if(nums[mid] > target)
                hi = mid-1;
            else
                lo = mid;
        }
        
        return nums[lo] == target;
    }
}