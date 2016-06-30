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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //make p the smaller node and q the bigger node
        if(p.val > q.val){
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        
        while(true){
            if(p == root || q == root || root == null)
                return root;
            if(q.val < root.val){
                root = root.left;
            }
            else if(p.val > root.val){
                root = root.right;
            }
            else
                return root;
        }
        
        
        // return helper(root, small, big);
        
        
    }
    
    // public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
    //     if(p == root || q == root || root == null)
    //         return root;
    //     if(q.val < root.val){
    //         return helper(root.left, p, q);
    //     }
    //     else if(p.val > root.val){
    //         return helper(root.right, p, q);
    //     }
    //     else
    //         return root;
    // }
    
    //[2,1,3] node with value 1 node with value 3
}