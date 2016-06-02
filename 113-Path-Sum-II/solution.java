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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        List<Integer> list = new ArrayList<>();  
        build(root, sum, ans, list);
        return ans;
    }
    
    public void build(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> list){
        if(root.left == null && root.right == null){
            if(sum == root.val){
                list.add(root.val);
                ans.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
                return;
            }
        } 
            
        
        list.add(root.val);
        if(root.left != null)
            build(root.left, sum-root.val, ans, list);
        if(root.right != null)
            build(root.right, sum-root.val, ans, list);
        list.remove(list.size()-1);
    }
}