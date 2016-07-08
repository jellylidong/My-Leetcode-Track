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
    
    //inorder traverse but only keep the last one we traversed
    //a valid BST should alway increase when inorder traverse,
    //so if current node <= last one, return false
    
    // int pre = Integer.MIN_VALUE;
    
    // public boolean isValidBST(TreeNode root) {
    //     if(root == null)
    //         return true;
            
    //     if(root.left == null && root.right == null){
    //         if(root.val <= pre)
    //             return false;
                
    //         pre = root.val;
    //         return true;
    //     }
    //     boolean left = isValidBST(root.left);
    //     if(root.val <= pre)
    //         return false;
    //     else
    //         pre = root.val;
    //     boolean right = isValidBST(root.right);
        
    //     return left && right;
    // }
    
    
    //above code can not handle case [-2147483648] when we set the pre value int_min
    //to solve this, this a TreeNode instead
    
    //In order traversal
    TreeNode pre = null;
    
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
            
        if(root.left == null && root.right == null){
            
            if(pre != null && root.val <= pre.val)
                return false;
                
            pre = root;
            return true;
        }
        boolean left = isValidBST(root.left);
        //after this, pre is the left node of root
        if(pre != null && root.val <= pre.val)
            return false;
        else
            pre = root;
        boolean right = isValidBST(root.right);
        
        return left && right;
    }
    
    
    
    
    // [3,1,5,0,2,4,6,null,null,null,3] 
    // [1,null,1]
    // [-2147483648] 
    // when use max or min value, we should consider if the value can exist in the question, 
    // ie min value can be a node value
}