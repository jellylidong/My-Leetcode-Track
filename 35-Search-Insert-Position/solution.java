public class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while(i < nums.length && nums[i] < target)
            i++;
        if(i == 0)
            return 0;
        return i;
    }
}