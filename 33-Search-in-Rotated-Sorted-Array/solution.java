public class Solution {
    
    //!!!!!!!!!!!!
    /*
    tips for binary search
    always keep the nums[mid] == target condition so that avoid dead loop and early termination
    also, when change bound, always use mid+1 or mid-1 so that avoid dead loop
    */
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < nums[hi]){
                if(nums[mid] < target && target <= nums[hi])
                    lo = mid+1;
                else
                    hi = mid-1;
            }
            else{
                if(nums[lo] <= target && target < nums[mid])
                    hi = mid-1;
                else
                    lo = mid+1;
            }
        }
        
        return nums[lo] == target? lo:-1;
    }
}