public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0)
            return ans;
        int target = 0;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length-2){
            int lo = i+1;
            int hi = nums.length-1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum < target){
                    lo++;
                    while(lo < hi && nums[lo] == nums[lo-1]){
                        lo++;
                    }
                }
                else if(sum > target){
                    hi--;
                    while(hi > lo && nums[hi] == nums[hi+1])
                        hi--;
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[lo]);
                    list.add(nums[hi]);
                    ans.add(list);
                    lo++;
                    while(lo < hi && nums[lo] == nums[lo-1]){
                        lo++;
                    }
                    hi--;
                    while(hi > lo && nums[hi] == nums[hi+1])
                        hi--;
                    
                }
            }
            i++;
            while(i < nums.length && nums[i] == nums[i-1])
                i++;
        }
        
        return ans;
    }
}