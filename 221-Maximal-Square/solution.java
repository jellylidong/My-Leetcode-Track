public class Solution {
    public int maximalSquare(char[][] m) {
        int y = m.length;
        if(y == 0)
            return 0;
        int x = m[0].length;
        if(x == 0)
            return 0;
            
        int[][] len = new int[y+1][x+1];
        //len[i][j] means the max side length of squre with bottom-right corner m[i-1][j-1]
        int maxLen = 0;
        for(int i = 1; i <= y; i++){
            for(int j = 1; j <= x; j++){
                if(m[i-1][j-1] == '1'){
                    len[i][j] = Math.min(len[i-1][j-1], Math.min(len[i][j-1], len[i-1][j])) + 1;
                    maxLen = Math.max(maxLen, len[i][j]);
                }
            }
        }
        
        return maxLen*maxLen;
    }
}