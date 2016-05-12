public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        searchRange(nums, target, ans, 0, nums.length-1);
        return ans;
    }
    
    public void searchRange(int[] nums, int target, int[] ans, int lo, int hi){
        if(lo > hi)
            return;
        
        int mid = lo + (hi-lo)/2;
        if(nums[mid] > target)
            searchRange(nums, target, ans, lo, mid-1);
        else if(nums[mid] < target)
            searchRange(nums, target, ans, mid+1, hi);
        else{
            if(ans[0] == -1){
                ans[0] = mid;
                ans[1] = mid;
                searchRange(nums, target, ans, lo, mid-1);
                searchRange(nums, target, ans, mid+1, hi);
            }
            else {
                if(mid < ans[0]){
                    ans[0] = mid;
                    searchRange(nums, target, ans, lo, mid-1);
                }
                
                if(mid > ans[1]){
                    ans[1] = mid;
                    searchRange(nums, target, ans, mid+1, hi);
                }
            }
        }
        
    }
}