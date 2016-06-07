public class NumMatrix {

    int[][] nums;
    int[][] tree;

    public NumMatrix(int[][] nums) {
        this.nums = nums;
        this.tree = new int[nums.length+1][nums[0].length+1];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j++){
                for(int ii = i+1; ii < tree.length; ii += ii&(-ii)){
                    for(int jj = j+1; jj < tree[0].length; jj += jj&(-jj)){
                        tree[ii][jj] += nums[i][j];
                    }
                 }
            }
        }
    }

    public void update(int row, int col, int val) {
        for(int i = row+1; i < tree.length; i += i&(-i)){
            for(int j = col+1; j < tree[0].length; j += j&(-j)){
                tree[i][j] += val - nums[row][col];
            }
        }
        
        nums[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int s1 = sum(row1-1, col1-1);
        int s2 = sum(row2, col1-1);
        int s3 = sum(row1-1, col2);
        int s4 = sum(row2, col2);
        
        return s4 - s3 - s2 + s1;
    }
    
    public int sum (int row, int col){
        if(row < 0 || col < 0)
            return 0;
        int s = 0;
        
        for(int i = row+1; i > 0; i -= i&(-i)){
            for(int j = col+1; j > 0; j -= j&(-j)){
                s += tree[i][j];
            }
        }
        
        return s;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);