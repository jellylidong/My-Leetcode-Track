public class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target)
                return true;
                
            //pass by all the dup at hi
            if(nums[mid] < nums[hi]){
                if(nums[mid] < target && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid;
            }
            else if(nums[mid] == nums[hi]){
                hi--;
            }
            else{//nums[mid] > nums[hi]
                if(nums[lo] <= target && target < nums[mid])
                    hi = mid;
                else
                    lo = mid+1;
            }
            
        }
        
        return nums[lo] == target;
    }
}