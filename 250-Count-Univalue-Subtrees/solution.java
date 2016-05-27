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
    int ans;
    public int countUnivalSubtrees(TreeNode root) {
        ans =0;
        if(root == null)
            return 0;
        count(root);
        return ans;
    }
    
    public class pair{
        boolean isUnique;
        int val;
        pair(boolean isUnique, int val){
            this.isUnique = isUnique;
            this.val = val;
        }
    }
    
    public pair count(TreeNode root){
        if(root.left == null && root.right == null){
            ans++;
            return new pair(true, root.val);
        }
        pair left = new pair(true, root.val);
        pair right = new pair(true, root.val);
        if(root.left != null)
            left = count(root.left);
        
        if(root.right != null)
            right = count(root.right);
        if((left != null && left.isUnique && left.val == root.val) &&
           (right != null && right.isUnique && right.val == root.val)){
               ans++;
               return new pair(true, root.val);
           } 
           
        return new pair(false, root.val);
    }
}