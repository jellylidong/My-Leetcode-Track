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

    public int closestValue(TreeNode root, double target) {
        //think about which direction to go can make the diff smaller
        
        TreeNode next = target < root.val? root.left : root.right;
        //if target < root.val, only going left can make the diff smaller, vice versa
        if(next == null)
            return root.val;
        else{
            int nextVal = closestValue(next, target);
            return Math.abs(root.val-target) < Math.abs(nextVal-target)? root.val : nextVal;
        }
    }
}