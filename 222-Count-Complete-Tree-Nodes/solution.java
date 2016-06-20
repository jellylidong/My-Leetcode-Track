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
    public int countNodes(TreeNode root) {
        int count = 0;
        
        while(root != null){
            int hleft = 1;
            int hright = 1;
            
            TreeNode left = root.left;
            TreeNode right = root.right;
            
            while(left != null){
                hleft++;
                left = left.left;
            }
            while(right != null){
                hright++;
                right = right.left;
            }
            
            if(hleft == hright){
                count += pow(2, hleft-1);
                root = root.right;
            }
            else{
                count += pow(2, hright-1);
                root = root.left;
            }
        }
        
        return count;
    }
    
    public int pow(int base, int prime){
        int ans = 1;
        for(int i = 0; i < prime; i++)
            ans *= 2;
        return ans;
    }
}