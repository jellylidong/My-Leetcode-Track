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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        inorder(ans, root);
        return ans;
    }
    
    public void inorder(List<Integer> list, TreeNode root){
        if(root.left != null)
            inorder(list, root.left);
        list.add(root.val);
        if(root.right != null)
            inorder(list, root.right);
    }
}