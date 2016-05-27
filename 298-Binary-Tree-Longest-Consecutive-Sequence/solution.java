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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        
        dfs(root, 0);
        return max;
        
    }
    
    public void dfs(TreeNode root, int count){
        count++;
        max = Math.max(max, count);
        if(root.left != null){
            if(root.left.val == root.val + 1)
                dfs(root.left, count);
            else
                dfs(root.left, 0);
        }
        
        if(root.right != null){
            if(root.right.val == root.val + 1)
                dfs(root.right, count);
            else
                dfs(root.right, 0);
        }
    }
}