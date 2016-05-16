public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0)
            return 0;
        if(n == 1)
            return k;
        int same = k;
        int diff = k*(k-1);
        
        for(int i = 3; i <= n; i++){
            int tmp = diff;
            diff = (same + diff)*(k-1);
            same = tmp;
        }
        
        return same + diff;
        
    }
}

/*
assume before painting next post, we alreay have x ways
if we will paint difference color, there are x*(k-1) ways
if we will paint a same color, there are x ways
*/