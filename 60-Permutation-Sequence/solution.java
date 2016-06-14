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
        // if(k == 1){
        //     for(int num: candidate){
        //         if(num != 0)
        //             ans += num;
        //     }
        //     return ans;
        // }
        // k-1 is used for k = 1 and k = n!, if we use k here, these two cases will get index error
        int i = (k-1)/count[n-1] + 1;
        ans += candidate.get(i);
        candidate.remove(i);
        
        return ans + solve(n-1, k-(i-1)*count[n-1], candidate, count);
    }
}