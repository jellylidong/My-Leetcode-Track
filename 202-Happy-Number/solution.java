public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while(true){
            int sum = 0;
            int d = 1;
            while(n/d != 0){
                sum += Math.pow(n%d, 2);
            }
            if(set.contains(sum)){
                if(sum == 1)
                    return true;
                else
                    return false;
            }
            else{
                set.add(sum);
                n = sum;
            }
        }
        
        // return false;
    }
}