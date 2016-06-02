public class Solution {
    public void nextPermutation(int[] nums) {
        /*！！！！！
        remember the steps of generating next permutation
        for permutations the first permutation is an sorted array in ascending order, ie 1234
        the last one is an sorted array in descending order, ie 4321
        So how does it change one by one
        remember the following step
        step1: start from len-1, find the first number that nums[i-1] < nums[i]
               this means all numbers after index i (inclusive) is nums[i] >= nums[i+1], ie descending order
        step2: find the min number from nums[i...len-1] which is > nums[i-1], 
               assum its index is j
        step3: swap nums[i-1] with nums[j]
               reverse nums[i ... len-1]
        step4: repeat 1 to 3 until i == 0, whic means the whole array is in descending order
        
        The whole process is to put next bigger number to front, ant reverse the rest part
        
        */
        if(nums.length <= 1)
            return;
        
        int i = nums.length-1;
        //step 1
        for(; i > 0; i--){
            if(nums[i-1] < nums[i])
                break;
        }
        
        //corner case
        if(i == 0){//whole array already in descending order, reverse it all so that it start from the first permutation
            reverse(nums, 0, nums.length-1);
            return;
        }
            
        //step 2
        int k = i;
        for(; k < nums.length; k++){
            if(nums[k] <= nums[i-1])
                break;
        }
        k--;
        int tmp = nums[i-1];
        nums[i-1] = nums[k];
        nums[k] = tmp;
        
        //step 3
        int lo = i;
        int hi = nums.length-1;
        reverse(nums, lo, hi);
        
    }
    
    public void reverse(int[] nums, int lo, int hi){
        while(lo < hi){
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            
            lo++;
            hi--;
        }
    }
}