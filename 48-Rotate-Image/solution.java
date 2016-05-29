public class Solution {
    
    //rotate img clockwise 90 degree:
    //upside, reverse left-up-right-bottom symmetry
    
    //if rotate anticlock wise 90 degree
    //left-right exchange, then left-up-right-bottom reverse
    public void rotate(int[][] m) {
        for(int i = 0; i < m.length/2; i++){
            for(int j = 0; j < m[0].length; j++){
                int tmp = m[i][j];
                m[i][j] = m[m.length-1-i][j];
                m[m.length-1-i][j] = tmp;
            }
        }
        
        for(int i = 0; i < m.length; i++){
            for(int j = i; j < m[0].length; j++){
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i]= tmp;
            }
        }
    }
}