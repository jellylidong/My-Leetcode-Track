public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length == 0)
            return ans;
        
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        while(i < nums.length){
            while(j < nums.length && nums[j-1]+1 == nums[j])
                j++;
            if(nums[i] != nums[j-1])
                ans.add(nums[i] + "->" + nums[j-1]);
            else
                ans.add(nums[i]+"");
            i = j;
            j++;
        }
        return ans;
    }
}