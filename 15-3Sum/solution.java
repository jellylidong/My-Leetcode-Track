public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        if(nums.length == 0)
            return ans;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1;){
            int lo = i+1;
            int hi = nums.length-1;
            while(lo < hi){
                if(nums[i] + nums[lo] + nums[hi] > 0)
                    hi--;
                else if(nums[i] + nums[lo] + nums[hi] < 0)
                    lo++;
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[lo]);
                    list.add(nums[hi]);
                    ans.add(list);
                    lo++;
                    hi--;
                    while(lo < hi && nums[lo-1] == nums[lo])
                        lo++;
                    while(lo < hi && nums[hi+1] == nums[hi])
                        hi--;
                }
            }
            i++;
            while(i < nums.length-1 && nums[i] == nums[i-1])
                i++;
        }
        return ans;
    }
}