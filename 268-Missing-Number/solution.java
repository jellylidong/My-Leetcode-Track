public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int n: nums)
            sum += n;
        int len = nums.length;
        int sum2 = (len+1)*(len)/2;
        
        return sum2 - sum;
    }
}