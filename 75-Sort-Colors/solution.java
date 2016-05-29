public class Solution {
    // public void sortColors(int[] nums) {
    //     int red = 0;
    //     int white = 0;
    //     int blue = 0;
    //     for(int i = 0; i < nums.length; i++){
    //         int n = nums[i];
    //         if(n == 0)
    //             red++;
    //         else if(n == 1)
    //             white++;
    //         else
    //             blue++;
    //     }
        
    //     for(int i = 0; i < nums.length; i++){
    //         if(i < red)
    //             nums[i] = 0;
    //         else if(i < red+white)
    //             nums[i] = 1;
    //         else
    //             nums[i] = 2;
    //     }
    // }
    
    //started because fail follow up 
    public void sortColors(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        
        for(int i = 0; i <= hi; i++){
            while(nums[i] == 2 && i < hi){
                swap(nums, i, hi);
                hi--;
            }
            while(nums[i] == 0 && i > lo){
                swap(nums, i, lo);
                lo++;
            }
                
        }
        
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}