public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //key is sum of [0...i], value is current index i
        int sum = 0;
        int max = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == k)
                max = Math.max(max, i+1); // i+1 always > previous max
            else if(map.containsKey(sum-k))
            //map.containsKey(sum-k) means there is a position that key is sum-k (assume j)
            //then sum of [j+1...i] is k, so a new length can be i- map.get(sum-k)
                max = Math.max(max, i - map.get(sum-k));
                
            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        
        return max;
    }
    
    
}