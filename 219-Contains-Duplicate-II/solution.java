public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k <= 0 || k >= nums.length)
            return false;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i >= k){
                set.remove(nums[k-i]);
            }
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}