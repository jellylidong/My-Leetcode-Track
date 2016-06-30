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
    TreeNode n1 = null;
    TreeNode n2 = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
    
    public void traverse(TreeNode root){
        if(root == null)
            return;
            
        traverse(root.left);
        
        if(n1 == null && pre.val > root.val)
            n1 = pre;
        if(n1 != null && pre.val > root.val)
            n2 = root;
            
        pre = root;
        
        traverse(root.right);
    }
    
    //[0,1]
}