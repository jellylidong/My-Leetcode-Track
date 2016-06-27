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
    public int kthSmallest(TreeNode root, int k) {
        int left = count(root.left);
        if(k <= left)
            return kthSmallest(root.left, k);
        else if(1+left == k)
            return root.val;
        else
            return kthSmallest(root.right, k-(left+1));
    }
    
    public int count(TreeNode root){
        if(root == null)
            return 0;
            
        return 1 + count(root.left) + count(root.right);
    }
    
    //if the BST is modifiable, we nned to build a tree with count in each node, ie
    /*
    public class nodeWithCount{
        nodeWithCount left;
        nodeWithCount right;
        int val;
        int count = 0;
        node(int val){
            this.val = val;
        }
    }
    
    //the count is the amount of children node of current node
    //once we have this count value, we don't have to count the children nodes, we can use it directly
    //so build such a tree take O(n)
    //insert and delet take O(n)
    //find the kth smallest number take O(height) ie O(lgn)
    */
}