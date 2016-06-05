public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
       
        if(nums.length == 0)
            return ans;
            
        for(int i = 0; i < nums.length-3;){
            for(int j = i+1; j < nums.length-2;){
                int lo = j+1;
                int hi = nums.length-1;
                while(lo < hi){
                    int sum = target - nums[i] - nums[j];
                    if(nums[lo] + nums[hi] < sum)
                        lo++;
                    else if(nums[lo] + nums[hi] > sum)
                        hi--;
                    else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]); list.add(nums[j]);
                        list.add(nums[lo]); list.add(nums[hi]);
                        ans.add(list);
                        lo++;
                        while(lo < hi && nums[lo] == nums[lo-1])
                            lo++;
                        hi--;
                        while(hi > lo && nums[hi] == nums[hi+1])
                            hi--;
                    }
                }
                j++;
                while(j < nums.length-2 && nums[j] == nums[j-1])
                    j++;
            }
            i++;
            while(i < nums.length-3 && nums[i] == nums[i-1])
                i++;
        }
        
        return ans;
    }
}