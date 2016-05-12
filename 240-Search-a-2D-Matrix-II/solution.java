public class Solution {
    public boolean searchMatrix(int[][] m, int target) {
        int y = m.length;
        int x = m[0].length;
        
        int loy = 0; int hiy = y-1;
        // int lox = 0; int hix = x-1;
        
        for(int i = 0; i < y; i++){
            int lox = 0; int hix = x-1;
            
            while(lox <= hix){
                int midx = lox + (hix-lox)/2;
                if(m[i][midx] == target)
                    return true;
                else if(m[i][midx] > target){
                    hix = midx-1;
                }
                else if(m[i][midx] < target){
                    lox = midx+1;
                }
                
            }
        }
        return false;
    }
}