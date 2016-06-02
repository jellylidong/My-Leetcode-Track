public class Solution {
    //the idea is to generate next permutation and add it to ans
    //originally, we use a hashSet to check if we already has the same permutation when there are dups
    //this is time and space expensive, don't do it!!!!
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(toList(nums));
        
        int len = nums.length-1;
        while(true){
            int i = len;
            while(i > 0){
                if(nums[i-1] < nums[i])
                    break;
                i--;
            }
            if(i == 0)
                break;
            int j = len;
            while(j >= i){
                if(nums[j] > nums[i-1])
                    break;
                j--;
            }
            
            swap(nums, i-1, j);
            reverse(nums, i, len);
            ans.add(toList(nums));
        }
        
        return ans;
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public void reverse(int[] nums, int lo, int hi){
        while(lo < hi){
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
    }
    
    public List<Integer> toList(int[] nums){
        List<Integer>  res = new ArrayList<>();
        for(int n: nums)
            res.add(n);
        return res;
    }
}