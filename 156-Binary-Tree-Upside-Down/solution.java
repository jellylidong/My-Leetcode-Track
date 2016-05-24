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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
      if(root == null || root.left == null && root.right == null) //only no child node will we stop going down
            return root;
      
      TreeNode newRoot = upsideDownBinaryTree(root.left);
      root.left.left = root.right;
      root.left.right = root;
      
      //don't forget
      root.left = null;
      root.right = null;
      
      return newRoot;
    
    }
}