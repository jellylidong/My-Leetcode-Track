public class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = digit2Sum(slow);
            fast = digit2Sum(fast);
            fast = digit2Sum(fast);
        }while(slow != fast);
        
        if(slow == 1)
            return true;
        return false;
    }
    
    public int digit2Sum(int n){
        int sum = 0;
            int d = 1;
        
        while(n != 0){
            sum += Math.pow(n%10, 2);
            n = n/10;
        }
        return sum;
    }
}