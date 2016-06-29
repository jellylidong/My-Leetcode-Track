public class Solution {
    public boolean isHappy(int n) {
        // HashSet<Integer> set = new HashSet<>();
        // while(true){
        //     int sum = 0;
        //     while(n != 0){
        //         int num = n%10;
        //         sum += num*num;
        //         n /= 10;
        //     }
        //     if(set.contains(sum))
        //         return false;
        //     else if(sum == 1)
        //         return true;
        //     else
        //         set.add(sum);
        //     n = sum;
        // }
        
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int sum = 0;
        while(true){
            int num = n%10;
            n = n/10;
            sum += num*num;
            if(n == 0){
                if(sum == 1)
                    return true;
                else if(set.contains(sum))
                    return false;
                else{
                    set.add(sum);
                    n = sum;
                }
                sum = 0;
            }
        }
    }
}