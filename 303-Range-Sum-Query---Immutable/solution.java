public class NumArray {
    int[][] sum;
    public NumArray(int[] nums) {
        int len = nums.length;
        sum = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                sum[i][j] = (i == j)? nums[i]: sum[i][j-1];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sum[i][j];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);