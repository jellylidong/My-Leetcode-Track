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
    int ans = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        minDepth(root, 1);
        return ans;
    }
    
    public void minDepth(TreeNode root, int curDepth){
        
        if(root.left == null && root.right == null)
            ans = Math.min(curDepth, ans);
        if(root.left != null)
            minDepth(root.left, curDepth+1);
        if(root.right != null)
            minDepth(root.right, curDepth+1);
    }
}