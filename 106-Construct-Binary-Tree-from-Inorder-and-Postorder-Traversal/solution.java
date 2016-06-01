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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public TreeNode buildTree(int[] inorder, int inlo, int inhi, int[] postorder,int postlo, int posthi) {
        if(inlo > inhi || postlo > posthi)
            return null;
        int rootId = inlo;
        for(int i = inlo; i <= inhi; i++){
            if(inorder[i] == postorder[posthi]){
                rootId = i;
                break;
            }
        }
        
        TreeNode root = new TreeNode(inorder[rootId]);
        root.left = buildTree(inorder, inlo, rootId-1, postorder, postlo, postlo+rootId-inlo-1);
        root.right = buildTree(inorder, rootId+1, inhi, postorder, postlo+rootId-inlo, posthi-1);
        
        return root;
    }
}