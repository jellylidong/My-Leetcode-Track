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
    
    //what we need to notice is that we can choose to rob or not to rob one node
    //so for each node, it has two different values (robbed and not robbed)
    
    //node, (robbed, value)
    HashMap<TreeNode, HashMap<Boolean, Integer>> map;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        return Math.max(rob(root, true), rob(root, false));
    }
    
    public int rob(TreeNode root, boolean robbed){
        if(root == null)
            return 0;
        
        if(!map.containsKey(root))
            map.put(root, new HashMap<Boolean, Integer>());
        
         
        if(robbed){
            if(map.get(root).containsKey(robbed))
                return map.get(root).get(robbed);
            int val = root.val + rob(root.left, false) + rob(root.right, false);
            map.get(root).put(robbed, val);
            return val;
        }
        else{//note here, roobbed == false here, so we still put robbbed, not !robbed
            if(map.get(root).containsKey(robbed))
                return map.get(root).get(robbed);
            int val = Math.max(rob(root.left, true), rob(root.left, false)) + Math.max(rob(root.right, true), rob(root.right, false));
            map.get(root).put(robbed, val);
            return val;
        }
    }
}