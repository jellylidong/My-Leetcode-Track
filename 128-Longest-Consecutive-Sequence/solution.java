public class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        if(nums.length == 0)
            return max;
        HashMap<Integer, Integer> map = new HashMap<>();//key: number, value: max length of sequence start with number
        for(int n: nums)
            map.put(n, 1);
            
        for(int n: nums){
            int cur = n;
            int len = map.get(cur);
            // System.out.println(len);
            while(map.containsKey(cur+1)){
                len ++;
                cur = cur+1;
            }
            map.put(n, len);
            max = Math.max(max, len);
        }
        
        return max;
    }
}