public class Solution {
    public int minCut(String s) {
        int len = s.length();
        if(len == 0)
            return 0;
            
        boolean[][] isP = new boolean[len][len];// isP[i][j] mean s.substring(i, j+1) isP
        int[] cut = new int[len]; // cut[i] is the min cut of s.substring(i);
        
        for(int i = len-1; i >= 0; i--){
            cut[i] = len-i-1;// s.substring(i).length()-1
            for(int j = i; j < len; j++){
                if(s.charAt(j) == s.charAt(i) && (j-i <= 1 || isP[i+1][j-1])){//(same positon || not same position but isP)
                    isP[i][j] = true;
                    // if(j == len-1)
                    //     cut[i] = 0;
                    // else
                        cut[i] = Math.min(cut[i], 1+cut[j+1]); 
                        // since isP[i][j],we may cut it as s.substring(i, j+1) ans s.substring(i+1)
                } 
            }
        }
        
        return cut[0];
    }
}