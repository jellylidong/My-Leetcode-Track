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
        int left = count(root.left);
        if(k <= left)
            return kthSmallest(root.left, k);
        else if(1+left == k)
            return root.val;
        else
            return kthSmallest(root.right, k-(left+1));
    }
    
    public int count(TreeNode root){
        if(root == null)
            return 0;
            
        return 1 + count(root.left) + count(root.right);
    }
}