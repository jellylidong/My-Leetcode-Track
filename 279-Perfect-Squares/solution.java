public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int numSquares(int n) {
        if(n <= 3)
            return n;
        
        if(map.containsKey(n))
            return map.get(n);
            
        int min = Integer.MAX_VALUE;    
        for(int i = 2; i*i <= n; i++){
            min = Math.min(min, numSquares(n-i*i));
        }
        
        map.put(n, 1+min);
        return 1 + min;
    }
}