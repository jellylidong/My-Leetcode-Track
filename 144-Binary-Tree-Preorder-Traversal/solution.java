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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        preOrder(ans, root);
        return ans;
    }
    
    public void preOrder(List<Integer> list, TreeNode root){
        list.add(root.val);
        if(root.left != null)
            preOrder(list, root.left);
        if(root.right != null)
            preOrder(list, root.right);
    }
}