public class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        combinationSum2(nums, 0, target, ans, list);
        return ans;
    }
    
    public void combinationSum2(int[] nums, int start, int target, List<List<Integer>> ans, List<Integer> list) {
        
        //!!!!!!!!!
        //The early termination must be added, otherwise TLE
        
        //since the numbers are sorted, so if we alreay get target == 0
        //it's not possible that adding more numbers can make another results
        //so return;
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        //since the numbers are sorted, once it's < 0, target-nums[i] can only makes it smaller
        //so return
        if(target < 0)
            return;
            
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