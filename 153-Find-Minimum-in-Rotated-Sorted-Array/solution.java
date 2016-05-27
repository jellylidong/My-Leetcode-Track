public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end= nums.length-1;
        
        while(start < end){
            //if start number < end number, there is no rotation, so return start number
            if(nums[start] < nums[end])
                return nums[start];
            int mid = start + (end-start)/2;
            //if mid number >= start number, (note it's >=, only > will be wrong for [2,1]), it means the rotated part is at right part
            if(nums[mid] >= nums[start])
                start = mid+1;
            //else the rotated part is at left part
            else
                end = mid;
        }
        
        return nums[start];
    }
}