public class Solution {
    public int hIndex(int[] cs) {
        for(int i = 0; i < cs.length; i++){
            if(cs[i] >= cs.length-i)
                return cs.length-i;
        }
        return 0;
    }
}