public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return 10;
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 10;
        count[2] = 81;
        for(int i = 3; i <= n; i++){
            count[i] = count[i-1] * (9-i+2);
        }
        
        int sum = 0;
        for(int i = 1; i <= n; i++)
            sum += count[i];
            
        return sum;
    }
}