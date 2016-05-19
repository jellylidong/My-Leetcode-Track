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
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        makePath(root, "");
        return ans;
    }
    
    public void makePath(TreeNode root, String s){
        if(root == null)
            return;
        if(s.length() != 0){
            s += "->" + root.val;
        }
        else
            s += root.val;
        if(root.left == null && root.right == null)
            ans.add(s);
        if(root.left != null)
            makePath(root.left, s);
        if(root.right != null)
            makePath(root.right, s);
        
    }
}