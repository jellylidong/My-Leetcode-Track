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
    public int rob(TreeNode root) {
        return Math.max(rob(root, true), rob(root, false));
    }
    
    public int rob(TreeNode root, boolean robbedCur){
        if(root == null)
            return 0;
            
        if(robbedCur){
            return root.val + rob(root.left, false) + rob(root.right, false);
        }
        else{
            return Math.max(rob(root.left, true), rob(root.left, false)) + Math.max(rob(root.right, true), rob(root.right, false));
        }
    }
}