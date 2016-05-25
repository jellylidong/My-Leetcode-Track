// Don't understand bit manipulation method

public class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            int count = map.getOrDefault(n, 0);
            map.put(n, count+1);
        }
        
        for(int n: map.keySet()){
            if(map.get(n) < 3)
                return n;
        }
        return 0;
    }
}