public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> candidate = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            candidate.add(i);
        
        int[] count = new int[n+1];
        count[0] = 1;
        for(int i = 1; i <= n; i++)
            count[i] = i*count[i-1];
            
        return solve(n ,k, candidate, count);
    }
    
    public String solve(int n, int k, List<Integer> candidate, int[] count){
        if(n == 0)
            return "";
        String ans = "";
        int i = k/count[n-1];
        ans += candidate.get(i+1);
        candidate.remove(i+1);
        
        return ans + solve(n-1, k-i*count[n-1], candidate, count);
    }
}