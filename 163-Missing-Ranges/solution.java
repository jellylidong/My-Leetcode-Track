public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        
        int lo = -1;
        int hi = -1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= lower){
                lo = i;
                break;
            }
        }
        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] <= upper){
                hi = i;
                break;
            }
        }
        
        if(lo == -1 || hi == -1){
            if(lower == upper){
                ans.add(lower+"");
            }
            else
                ans.add(lower + "->" + upper);
            return ans;
        }
           
        // if(lower < nums[lo]){
        //     if(lower == nums[lo]-1){
        //         ans.add(lower+"");
        //     }
        //     else{
        //         ans.add(lower + "->" + (nums[i]-1))
        //     }
        //     lower = nums[lo]+1;
        // }
        // if(lower == nums[0]){
        //     lo++;
        // }
        for(int i = lo; i <= hi; i++){
            if(lower < nums[i]){
                if(lower == nums[i]-1)
                    ans.add(lower+"");
                else
                    ans.add(lower +"->" + (nums[i]-1));
                lower = nums[i] + 1;
            }
            else if(lower == nums[i]){
                lower = nums[i] + 1;
            }
            
        }
        if(nums[hi] < upper){
            if(nums[hi] + 1 == upper)
                ans.add((nums[hi]+1) + "");
                
            else
                ans.add((nums[hi]+1) + "->" + upper);
        }
        
        return ans;
    }
}