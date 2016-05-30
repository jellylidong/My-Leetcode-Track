public class Solution {
    
    //follow up of O(constant) failed
    public void setZeroes(int[][] m) {
        
        int y = m.length;
        if(y == 0)
            return;
        int x = m[0].length;
        if(x == 0)
            return;
            
        //decide if m[0][0] should be labeled 0
        boolean r0 = false;
        boolean c0 = false;
        for(int i = 0; i < x; i++){
            if(m[0][i] == 0){
                r0 = true;
                break;
            }
        }
        for(int i = 0; i < y; i++){
            if(m[i][0] == 0){
                c0 = true;
                break;
            }
        }
        
        for(int i = 1; i < y; i++){
            for(int j = 1; j < x; j++){
                if(m[i][j] == 0){
                    m[i][0] = 0;
                    m[0][j] = 0;
                }
            }
        }
        
        for(int i = y-1; i >= 1; i--){
            for(int j = x-1; j >= 1; j--){
                if(m[i][0] == 0 || m[0][j] == 0)
                    m[i][j] = 0;
            }
        }
        
        if(r0){
            for(int i = 0; i < x; i++)
                m[0][i] = 0;
        }
        if(c0){
            for(int j = 0; j < y; j++)
                m[j][0] = 0;
        }
    }
}