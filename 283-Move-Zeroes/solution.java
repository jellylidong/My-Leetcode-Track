public class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for(int n: nums){
            if(n != 0){
                nums[pos] = n;
                pos++;
            }
        }
        while(pos < nums.length){
            nums[pos] = 0;
            pos++;
        }
    }
}