public class Solution {
    int ans;
    public int minimumTotal(List<List<Integer>> tri) {
        ans = Integer.MAX_VALUE;
        minSum(tri, 0, 0, 0);
        return ans;
    }
    
    public void minSum(List<List<Integer>> tri, int level, int pp, int sum){
        if(level == tri.size()){
            ans = Math.min(ans, sum);
            return;
        }
            
        // if(pp - 1 >= 0)
        //     minSum(tri, level+1, pp-1, sum + tri.get(level).get(pp-1));
        minSum(tri, level+1, pp, sum + tri.get(level).get(pp));
        if(pp+1 < tri.get(level).size())
            minSum(tri, level+1, pp+1, sum + tri.get(level).get(pp+1));
    }
}