public class Solution {
    boolean[] isPrime;
    public int countPrimes(int n) {
        isPrime = new boolean[n+1];
        int count = 0;
        for(int i = 2; i <= n; i++){
            isPrime[i] = true;
        }
        
        for(int i = 2; i*i < n; i++){
            if(!isPrime[i])
                continue;
            for(int j = i*i; j < n; j+=i){
                isPrime[j] = false;
            }
        }
        
        for(int i = 2; i < n; i++){
            if(isPrime[i])
                count++;
        }
        return count;
    }
    
    
}