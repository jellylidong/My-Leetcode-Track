public class Solution {
    ///!!!!!!!!!!!!!!!!!!!!
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        
    }
    
    public void reverse(int[] nums, int lo, int hi){
        // for(int i = lo; i <= lo + (hi-lo)/2; i++){
        //     int tmp = nums[i];
        //     nums[i] = nums[hi-(i-lo)];
        //     nums[hi-(i-lo)] = tmp;
        // }
        
        //this is better, can avoid error when length is 0
        while(lo < hi){
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            lo++;
            hi--;
        }
    }
}

//m1 run move one position for k times

//m2 store the last k numbers, move k position for one time and use the stored array to modify the first k position

//?????? m3 swap first k numbers and last k numbers, ie swap(1, k-1), swap(2, k-2) ...., 
//after swap done, the first k numbers are in correct position, but the the rest n-k numbers are reversed, we need to reverse it

//m4 revers first n-k numbers, last k numbers, then all numbers