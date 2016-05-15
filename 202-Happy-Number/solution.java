public class Solution {
    public boolean isHappy(int n) {
        if(n <= 1)
            return true;
            
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while(true){
            int sum = 0;
            int d = 1;
            
            while(n != 0){
                sum += Math.pow(n%10, 2);
                n = n/10;
            }
            if(sum == 1)
                return true;
            if(set.contains(sum))
                return false;
            set.add(sum);
            n = sum;
        }
    }
}