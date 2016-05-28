public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0)
            return ans;
            
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        ans.add(list);
        
        //1st number, 1 position: 1
        //2nd number, 2 position: 21, 12
        //3rd, 3 pos: 321, 231, 213, 312, 132, 123
        //so the method is insert ith number to i-1th results
        //for each list in i-1the result, insert nums[i] to position 0 to list.size()
        //note, we need insert at both 0 and list.size(), ie head and tail
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