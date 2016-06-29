public class Solution {
    public int findMin(int[] nums) {
        // int lo = 0;
        // int hi = nums.length - 1;
        
        // while(lo < hi){
        //     if(nums[lo] < nums[hi])
        //         return nums[lo];
                
        //     int mid = lo + (hi-lo)/2;
            
        //     if(nums[mid] >= nums[lo])
        //         lo = mid+1;
        //     else
        //         hi = mid;
            
        // }
        
        // return nums[lo];
        
        //just type again
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi){
            
            if(nums[lo] < nums[hi]){
                //current range is not rotated
                return nums[lo];
            }
            
            else{
                int mid = lo + (hi-lo)/2;
                //current range is rotated
                if(nums[mid] >= nums[lo]){
                    //since current range is rotated
                    //if range nums[lo, mid] is ascending, then the min can only be at right of mid(exclusive)
                    lo = mid+1;
                }
                else{
                    //since current range is rosted,
                    //if range nums[mid, hi] is not always ascending, then the min must be at left of mid(inclusive)
                    hi = mid;
                }
            }
        }
        
        return nums[lo];
    }
}