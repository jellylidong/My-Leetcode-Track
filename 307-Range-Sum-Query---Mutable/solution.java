public class NumArray {
    // segmentTree root;
    // public NumArray(int[] nums) {
    //     this.root = genTree(nums, 0, nums.length-1);
    // }

    // void update(int i, int val) {
    //     update(root, i, val);
    // }

    // public int sumRange(int i, int j) {
    //     return sumRange(root, i, j);
    // }
    
    // class segmentTree{
    //     int lo, hi; //range of nums that will be used to build current tree node
    //     segmentTree left, right;
    //     int sum;
        
    //     segmentTree(int[] nums, int lo, int hi){
    //         this.lo = lo;
    //         this.hi = hi;
    //         this.left = null;
    //         this.right = null;
    //         this.sum = 0;
    //     }
    // }    // public NumArray(int[] nums) {
    //     this.root = genTree(nums, 0, nums.length-1);
    // }

    // void update(int i, int val) {
    //     update(root, i, val);
    // }

    // public int sumRange(int i, int j) {
    //     return sumRange(root, i, j);
    // }
    
    // public segmentTree genTree(int[] nums, int lo, int hi){
    //     if(lo > hi)
    //         return null;
    //     else{
    //         segmentTree root = new segmentTree(nums, lo, hi);
    //         if(lo == hi){
    //             root.sum = nums[lo];
    //         }
    //         else{
    //             int mid = lo + (hi-lo)/2;
    //             root.left = genTree(nums, lo, mid);
    //             root.right = genTree(nums, mid+1, hi);
    //             root.sum = root.left.sum + root.right.sum;
    //         }
    //         return root;
    //     }
    // }
    
    // public void update(segmentTree root, int pos, int val){
    //     if(root.lo == root.hi)
    //         root.sum = val;
    //     else{
    //         int lo = root.lo;
    //         int hi = root.hi;
    //         int mid = lo + (hi-lo)/2;
    //         if(pos <= mid)
    //             update(root.left, pos, val);
    //         else
    //             update(root.right, pos, val);
                
    //         root.sum = root.left.sum + root.right.sum;
    //     }
    // }
    
    // public int sumRange(segmentTree root, int lo, int hi){
    //     if(root.lo == lo && root.hi == hi)
    //         return root.sum;
            
    //     else{
    //         int mid = root.lo + (root.hi-root.lo)/2;
    //         if(hi <= mid)
    //             return sumRange(root.left, lo, hi);
    //         else if(lo >= mid+1)
    //             return sumRange(root.right, lo, hi);
    //         else
    //             return sumRange(root.left, lo, mid) + sumRange(root.right, mid+1, hi);
    //     }
    // }
    
    
    //above code works well, it uses segment tree, it uses 2* 2^(log(sub 2, n)-1) space
    //in this method, we try to use binary index tree
    //for a tree node tree[i], it means the sum start from (i+1) with most right set bit flipped, end with i, both are inclusive
    //to go right from nums[i], k = i+1; k < tree.length; k += k&(-k)
    //to go up from nums[i], k = i+1; k > 0; k -= k&(-k)
    //remember the above two line !!!!!!!!!!!!!!
    int[] nums;
    int[] tree;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < tree.length; j += j&(-j)){ // go right
                tree[j] += nums[i];
            }
        }
    }

    void update(int i, int val) {
        for(int j = i+1; j < tree.length; j += j&(-j)){ // go right
            tree[j] += val - nums[i];
        }
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int s1 = sumRange(i-1);
        int s2 = sumRange(j);
        return s2 - s1;
    }
    
    public int sumRange(int i){
        if(i < 0)
            return 0;
        int s = 0;
        for(int j = i+1; j > 0; j -= j&(-j)) // go up
            s += tree[j];
            
        return s;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);