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
    HashMap<TreeNode, Integer> map;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        return Math.max(rob(root, true), rob(root, false));
    }
    
    public int rob(TreeNode root, boolean robbedCur){
        if(root == null)
            return 0;
        
        
         
        if(robbedCur){
            if(map.containsKey(root))
                return map.get(root);
            int val = root.val + rob(root.left, false) + rob(root.right, false);
            map.put(root, val);
            return val;
        }
        else{
            int val = Math.max(rob(root.left, true), rob(root.left, false)) + Math.max(rob(root.right, true), rob(root.right, false));
            // map.put(root, val);
            return val;
        }
    }
}