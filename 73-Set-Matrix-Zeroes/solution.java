public class Solution {
    public void setZeroes(int[][] m) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                if(m[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for(int r: row){
            for(int i = 0; i < m[0].length; i++)
                m[r][i] = 0;
        }
        
        for(int c: col){
            for(int i = 0; i < m.length; i++)
                m[i][c] = 0;
        }
    }
}