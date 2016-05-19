public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        int len = nums.length;
        sum = new int[len];
        sum[0] = nums[0];
        for(int i = 1; i < len; i++)
            sum[i] = sum[i-1] + nums[i];
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return sum[j];
        else
            return sum[j] - sum[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);