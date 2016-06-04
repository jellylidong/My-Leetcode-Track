public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0; 
        int j = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        
        for(i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= s && j <= i){
                sum -= nums[j++];
                // len = Math.min(len, i-j+1+1);
            }
            
            
            System.out.println(i + " " + j);
        }
        
        return len == Integer.MAX_VALUE?  0: len;
    }
}