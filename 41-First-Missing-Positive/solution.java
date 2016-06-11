public class Solution {
    //move all positive number to left, assume the positive part is nums[0...q-1]
    //note nums[i] itself can also be used as an index of this array
    //so we can lable exist number as negative if nums[i]'s value exist in nums[0...q-1]
    //see the label part of the code
    //then we go from left to right, the index of first un-labeled number mean the first missing positive number is index+1
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
        
        //label
        for(int i = 0; i < q; i++){
            int tmp = Math.abs(nums[i]); //nums[i] can be already labeled, so we need it's abs value
            if(tmp-1 < q && nums[tmp-1] > 0) 
            // note that for nums[0..q-1] it actually stores number from 1, so we need tmp-1 to get the correct index
            // also nums[0...q-1] stores number at most is q, so if tmp-1 >= q, ignore it
            // also there can be dup numbers, so nums[tmp-1] can be already labeled, so we need nums[tmp-1] to decide to label or not
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