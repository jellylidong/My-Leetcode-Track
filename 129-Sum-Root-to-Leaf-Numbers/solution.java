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
   
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
            
        return sumNumbers(root, 0);
            
        
    }
    
    public int sumNumbers(TreeNode root, int n) {
           if(root.left == null && root.right == null)
                return 10*n + root.val;
            int left = 0;
            int right = 0;
            
            if(root.left != null)
                left = sumNumbers(root.left, 10*n+root.val);
            if(root.right != null)
                right = sumNumbers(root.right, 10*n+root.val);
                
            return left + right;
    }
}