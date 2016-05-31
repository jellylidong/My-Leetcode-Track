public class Solution {
    public int hIndex(int[] c) {
        Arrays.sort(c);
        int len = c.length;
        for(int i = 0; i < len; i++){
            if(c[i] >= len-i)
                return len - i;
        }
        
        return 0;
    }
}