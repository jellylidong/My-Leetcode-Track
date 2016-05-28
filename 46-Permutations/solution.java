public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0)
            return ans;
            
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        ans.add(list);
        
        for(int i = 1; i < nums.length; i++){
            List<List<Integer>> newAns = new ArrayList<>();
            for(List<Integer> curList: ans){
                
                for(int j = 0; j <= curList.size(); j++){
                    List<Integer> newList = new ArrayList<>(curList);
                    newList.add(j, nums[i]);
                    newAns.add(newList);
                }
            }
            ans = newAns;
        }
        
        return ans;
    }
}