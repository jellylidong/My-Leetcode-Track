public class Solution {
    // HashMap<Integer, Integer> map = new HashMap<>();
    // public int numSquares(int n) {
    //     if(n <= 3)
    //         return n;
        
    //     if(map.containsKey(n))
    //         return map.get(n);
            
    //     int min = Integer.MAX_VALUE;    
    //     for(int i = 2; i*i <= n; i++){
    //         min = Math.min(min, numSquares(n-i*i));
    //     }
        
    //     map.put(n, 1+min);
    //     return 1 + min;
    // }
    
    //the above solution is too slow
    
    public int numSquares(int n) {
        if(n <= 0)
            return n;
        
        int[] count = new int[n+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 1; i+j*j <= n; j++){
                count[i+j*j] = Math.min(count[i+j*j], count[i] + 1);
            }
        }
        
        return count[n];
    }
    /*
        any number can be write as i+j*j, the corresponding count is count[i] + 1
        so find min from all combinations of i and j 
    */
    
}