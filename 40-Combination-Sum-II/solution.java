public class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        combinationSum2(nums, 0, target, ans, list);
        return ans;
    }
    
    public void combinationSum2(int[] nums, int start, int target, List<List<Integer>> ans, List<Integer> list) {
        
        if(target == 0)
            ans.add(new ArrayList<>(list));
            
        for(int i = start; i < nums.length; i++){
            //to avoid generate duplicate reulst, we don't add same number in the same dfs level
            if(i > start && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            combinationSum2(nums, i+1, target-nums[i], ans, list);
            list.remove(list.size()-1);
        }
    }
}