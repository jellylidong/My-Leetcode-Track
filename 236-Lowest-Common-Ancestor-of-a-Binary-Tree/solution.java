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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if one of the p and q equals to root, it means root is LCA
        if(p == root || q == root || root == null)
            return root;
        
        //else we need to earch node from lower level
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //if p,q's LCA is in left subtree, then right must be null, vice versa
        //if both left and right is not null, it means the LCA in upper level of left and right, ie root
        //otherwise, both left and right would be null when there's no LCA for the two node
        
        if(left != null && right != null)
            return root;
        
        if(left != null)
            return left;
        else
            return right;
    }
    
    /*
    [1,2,3]
    node with value 2
    node with value 3
    */
}