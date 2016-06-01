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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int prelo, int prehi, int[] inorder, int inlo, int inhi){
        if(inlo > inhi || prelo > prehi)
            return null;
            
        int rootId = inlo;
        for(int i =inlo; i <= inhi; i++){
            if(inorder[i] == preorder[prelo]){
                rootId = i;
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[rootId]);
        root.left = buildTree(preorder, prelo+1, prelo+1+(rootId-1-inlo), inorder, inlo, rootId-1);
        root.right = buildTree(preorder, prelo+1+(rootId-1-inlo)+1, prehi, inorder, rootId+1, inhi);
        
        return root;
    }
}