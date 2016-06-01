public class Solution {
    
    public int minimumTotal(List<List<Integer>> tri) {
        int ans = Integer.MAX_VALUE;
        
        for(int i = 1; i <tri.size(); i++){
            
            List<Integer> cur = tri.get(i);
            for(int j = cur.size()-1; j >= 0; j--){
                if(j == cur.size() - 1)
                    cur.set(j, cur.get(j) + tri.get(i-1).get(j-1));
                else if(j == 0)
                    cur.set(j, cur.get(j) + tri.get(i-1).get(j));
                else{
                    cur.set(j, cur.get(j) + Math.min(tri.get(i-1).get(j), tri.get(i-1).get(j-1)));
                }
            }
        }
        
        for(int n: tri.get(tri.size()-1)){
            ans = Math.min(ans, n);
        }
        
        return ans;
    }
    
    
}