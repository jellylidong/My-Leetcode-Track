public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        //swap first k with last k numbers
        for(int i = 0; i < k; i++){
            int tmp = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = tmp;
        }
        
        //reverse last n-k numbers
        for(int i = k; k < k + (n-k)/2; k++){
            int tmp = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = tmp;
        }
    }
}

//m1 run move one position for k times

//m2 store the last k numbers, move k position for one time and use the stored array to modify the first k position

//m3 swap first k numbers and last k numbers, ie swap(1, k-1), swap(2, k-2) ...., 
//after swap done, the first k numbers are in correct position, but the the rest n-k numbers are reversed, we need to reverse it

//m4 revers first n-k numbers, last k numbers, then all numbers