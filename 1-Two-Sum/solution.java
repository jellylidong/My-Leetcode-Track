public class Solution {
    public int[] twoSum(int[] nums, int value) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(value - nums[i])){
                ans[0] = map.get(value-nums[i]);
                ans[1] = i;
               break;
            }
            else{
                map.put(nums[i], i);
            }
        }
        
        return ans;
    }
}