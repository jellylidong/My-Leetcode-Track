/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
 
    public int kthSmallest(TreeNode root, int k) {
        int num = count(root.left);
        if(k <= num)
            return kthSmallest(root.left, k);
        else if(k == num+1)
            return root.val;
        else
            return kthSmallest(root.right, k-num-1);
    }
    
    public int count(TreeNode root){
        if(root == null)
            return 0;
            
        return 1 + count(root.left) + count(root.right);
    }
}

/*explain
count the number of left subtree;
if k <= count, it means the target is in the left subtree, return with func(root.left, k)
else if k == count+1, it means current root is our target, so return root.val
else(k > count+1), the target is in the right substree, so just return with func(root.right, k-(count+1))
*/