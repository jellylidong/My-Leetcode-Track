public class NumMatrix {

    int[][] sum;
    public NumMatrix(int[][] m) {
        int h = m.length;
        if(h == 0)
            return;
        int w = m[0].length;
        if(w == 0)
            return;
        sum = new int[h][w];
        sum[0][0] = m[0][0];
        for(int i = 1; i < w; i++)
            sum[0][i] = m[0][i-1] + m[0][i];
        for(int i = 1; i < h; i++)
            sum[0][i] = sum[0][i-1] + m[i][0];
            
        for(int i = 1; i < h; i++){
            for(int j = 1; j < w; j++)
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int p1 = row1-1 >= 0? sum[row1-1][col2]:0;
        int p2 = col1-1 >= 0? sum[row2][col1-1]:0;
        int p3 = (row1-1 >= 0 && col1-1 >= 0)? sum[row1-1][col1-1]:0;
        return sum[row2][col2] - p1 - p2 + p3;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);