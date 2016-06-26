public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
         ans.add(new ArrayList<Integer>());
        helper(nums, ans, new ArrayList<Integer>(), 0);
       
        return ans;
    }
    
    public void helper(int[] nums, List<List<Integer>> ans, List<Integer> curList, int start){
        for(int i = start; i < nums.length; i++){
            curList.add(nums[i]);
            ans.add(new ArrayList<Integer>(curList));
            helper(nums, ans, curList, i+1);
            curList.remove(curList.size()-1);
        }
    }
}