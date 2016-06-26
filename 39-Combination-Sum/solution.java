public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, target, new ArrayList<Integer>(), ans, 0, 0);
        
        return ans;
    }
    
    public void helper(int[] nums, int target, List<Integer> curList, List<List<Integer>> ans, int curSum, int start){
        if(curSum == target)
            ans.add(new ArrayList<Integer>(curList));
        else if(curSum < target){
            for(int i = start; i < nums.length; i++){
                curList.add(nums[i]);
                helper(nums, target, curList, ans, curSum+nums[i], i);
                curList.remove(curList.size()-1);
            }
        }
    }
}