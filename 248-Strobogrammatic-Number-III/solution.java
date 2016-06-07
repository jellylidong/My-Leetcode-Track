public class Solution {
    
    char[][] pairs = {{'0','0'}, {'1','1'}, {'6','9'}, {'8','8'}, {'9','6'}};
    int count = 0;
    
    public int strobogrammaticInRange(String low, String high) {
        //generate numbers from low.length to high.length;
        int loLen = low.length();
        int hiLen = high.length();
        
        for(int i = loLen; i <= hiLen; i++){
            gen(low, high, new char[i], 0, i-1);
        }
        
        return count;
    }
    
    public void gen(String low, String high, char[] cs, int s, int e){
        if(s > e){
            String res = new String(cs);
            // System.out.println(res);
            if((res.length() == low.length() && res.compareTo(low) < 0) || 
                (res.length() == high.length() && res.compareTo(high) > 0)) //to compare string number, they must have same length
                return;
            count++;
            return;
        }
        else{
            for(char[] p: pairs){
                cs[s] = p[0];
                cs[e] = p[1];
                
                if(cs.length != 1 && cs[0] == '0') // number start with 0 with length > 1 is invalid
                    continue;
                
                if(s < e || (s == e && p[0] == p[1])) // if s == e, the two chars must be the same
                    gen(low, high, cs, s+1, e-1);
            }
        }
    }
}