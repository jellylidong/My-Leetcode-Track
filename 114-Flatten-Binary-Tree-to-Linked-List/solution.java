/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 //!!!!!!!!!! still can not come up woth code by myself
 //start
public class Solution {
    TreeNode pre = null;
    //pre is used for store the root of lower level of current node
    //pre will be used as the right node of current root
    //and at the end of current level, pre will be current root
    
    //also for each left, root.left should be null
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        
        root.right = pre;
        root.left = null;
        pre = root;
            
        
        
    }
}