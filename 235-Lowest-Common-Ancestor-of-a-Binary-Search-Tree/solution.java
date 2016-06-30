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
        TreeNode small = p;
        TreeNode big = q;
        
        if(p.val > q.val){
            small = q;
            big = p;
        }
        return helper(root, small, big);
        
        
    }
    
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(p == root || q == root || root == null)
            return root;
        if(q.val < root.val){
            return helper(root.left, p, q);
        }
        else if(p.val > root.val){
            return helper(root.right, p, q);
        }
        else
            return root;
    }
    
    //[2,1,3] node with value 1 node with value 3
}