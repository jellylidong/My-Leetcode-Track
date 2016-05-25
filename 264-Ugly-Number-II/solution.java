public class Solution {
    public int nthUglyNumber(int n) {
        int[] ans = new int[n];
        ans[0] = 1;
        int i2=0, i3=0, i5=0;
        for(int i = 1; i <n; i++){
            ans[i] = Math.min(ans[i2]*2, Math.min(ans[i3]*3, ans[i5]*5));
            if(ans[i] == ans[i2] * 2)   i2++;
            if(ans[i] == ans[i3] * 3)   i3++;
            if(ans[i] == ans[i5] * 5)   i5++;
        }
        
        return ans[n-1];
    }
}