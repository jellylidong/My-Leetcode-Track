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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        return build(nums, 0, nums.length-1);
    }
    
    public TreeNode build(int[] nums, int lo, int hi){
        if(lo > hi)
            return null;
        if(lo == hi)
            return new TreeNode(nums[lo]);
        int mid = lo + (hi-lo)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, lo, mid-1);
        root.right = build(nums, mid+1, hi);
        return root;
    }
}