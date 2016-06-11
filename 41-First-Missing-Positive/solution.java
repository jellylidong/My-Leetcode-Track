public class Solution {
    public int firstMissingPositive(int[] nums) {
        int q = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                int tmp = nums[q];
                nums[q] = nums[i];
                nums[i] = tmp;
                q++; // finally q end as the index of first negative numebr
            }
        }
        
        for(int i = 0; i < q; i++){
            int tmp = Math.abs(nums[i]);
            if(tmp-1 < q && nums[tmp-1] > 0)
                nums[tmp-1] = -nums[tmp-1];
        }
        
        int i = 0;
        for(; i < q; i++){
            if(nums[i] > 0)
                break;
        }
        
        return i+1;
    }
}