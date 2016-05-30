public class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        gen(nums, 0, list);
        return ans;
    }
    
    public void gen(int[] nums, int start, List<Integer> list){
        ans.add(new ArrayList<Integer>(list));
        
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            gen(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}