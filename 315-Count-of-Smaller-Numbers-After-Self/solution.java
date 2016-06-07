public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        //build a BST from len-1 to 0,
        //count the number of nodes it traversed when going right while inserting
        //also use a varibale count to record the number of nodes in left subtring
        //the result will be the number of traversed node + preNode.count
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < len; i++)
            ans.add(0);
        if(len == 0)
            return ans;
            
        TreeNode root = new TreeNode(nums[len-1]);
        for(int i = len-2; i >= 0; i--){
            int count = insert(root, nums[i]);
            ans.set(i, count);
        }
        
        return ans;
    }
    
    public int insert(TreeNode root, int n){
        
        int count = 0;
        
        //first declare some rules
        //if currenct value n > root.val, we should go right, count should add root.count,
        //!!!!!!!!!!!! besides, if root.val != n, we should also add 1 to count
        //if current value = n, we can go both, but here, we go to right
        //if current value < n, we go to left, count should not change, root.count should plus 1 because there will be a node added to left
        
        TreeNode pre = root;
        while(root != null){
            if(n >= root.val){
                if(n != root.val)
                    count += 1;
                count += root.count;
                pre = root;
                root = root.right;
            }
            else{
                // count += 1;
                root.count++;
                pre = root;
                root = root.left;
            }
        }
        
        if(n >= pre.val)
            pre.right = new TreeNode(n);
        else
            pre.left = new TreeNode(n);
            
        return count;
    }
    
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        int count; // number of left tree nodes
        TreeNode(int val){
            this.val = val;
            this.count = 0;
        }
    }
    
    //[2,0,1]
    //[26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41]
    //[-1,-1]
}