public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        if(num == 0){
            ans[0] = 0;
            return ans;
        }
        if(num == 1){
            ans[0] = 0;
            ans[1] = 1;
            return ans;
        }
        // int[] ans = new int[num+1];
        ans[0] = 0;
        ans[1] = 1;
        int threshold = 2;
        int i = 2;
        for(; i <= num; i *= 2){
            for(int j = i; j < i*2 && j <= num; j++){
                if(j == i)
                    ans[j] = 1;
                else{
                    ans[j] = ans[i] + ans[j-i];
                }
            }
        }
        
        return ans;
    }
}