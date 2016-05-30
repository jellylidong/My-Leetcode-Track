public class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        gen(nums, list, 0);
        
        return ans;
    }
    
    public void gen(int[] nums, List<Integer> list, int start){
        ans.add(new ArrayList<Integer>(list));
        
        int i = start;
        while(i < nums.length){
            int count = 0;
            int j = i;
            while(j < nums.length && nums[i] == nums[j]){
                j++;
                count++;
            }
            for(int k = 1; k <= count; k++){
                
                for(int l = 1; l <= k; l++){
                    list.add(nums[i]);
                }
                gen(nums, list, i+count);
                for(int l = 1; l <= k; l++){
                    list.remove(list.size()-1);
                }
            }
            i += count;
        }
    }
}