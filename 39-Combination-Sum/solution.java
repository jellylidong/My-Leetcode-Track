public class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        
        List<Integer> list = new ArrayList<>();
        combinationSum(nums, 0, target, list);
        return ans;
    }
    
    public void combinationSum(int[] nums, int start, int target, List<Integer> list) {
            if(target > 0){
                for(int i = start; i < nums.length; i++){
                    if(i > start && nums[i] == nums[i-1])
                        continue;
                    list.add(nums[i]);
                    combinationSum(nums, i, target-nums[i], list);
                    list.remove(list.size()-1);
                }
            }
            else if(target == 0){
                ans.add(new ArrayList<>(list));
            }
    }
}