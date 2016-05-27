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
        if(root == null)
            return 0;
        return Math.max(rob(root, false), root.val + rob(root, true));
       
    }
    
    public int rob(TreeNode root, boolean robbedPre){
        if(root == null)
            return 0;
        int left = 0;
        int right = 0;
        
        if(robbedPre){
            left = 0 + rob(root.left, false);
            right = 0 + rob(root.right, false);
            return left + right;
        }
        else{
            left =  Math.max(rob(root.left, true) + (root.left == null? 0:root.left.val), rob(root.left, false));
            right = Math.max(rob(root.right, true) + (root.right == null? 0:root.right.val), rob(root.right, false));
            return left + right;
        }
        
    }
}