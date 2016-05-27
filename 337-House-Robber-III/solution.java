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

    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return rob(root, map);
       
    }
    
    public int rob(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
            
        int val = 0; 
        //the val for when current root is robbed
        //if current root is robbed, we can only start from root.left.children and root,right.children
        if(root.left != null){
            val += rob(root.left.left, map) + rob(root.left.right);
        }
        if(root.right != null){
            val += rob(root.right.left, map) + rob(root.right.right, map);
        }
        
        //rob(root.left) + rob(root.right) is the value for when current root is not robbed
        int max = Math.max(root.val + val, rob(root.left, map) + rob(root.right, map));
        map.put(root, max);
        return max;
        
    }
}