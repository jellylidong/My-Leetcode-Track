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
    //another way is to push inorder of mid, left, right
    //pop and store the value each time, then reverse the list
    
    //left, right, root
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(cur.right != null || cur.left != null){
                if(cur.right != null){
                    stack.push(cur.right);
                    // TreeNode tmp = cur.right;
                    cur.right = null;
                    // cur = tmp;
                }
                if(cur.left != null){
                    stack.push(cur.left);
                    // TreeNode tmp = cur.left;
                    cur.left = null;
                    // cur = tmp;;
                }
                
            }
            else{
                ans.add(stack.pop().val);
            }
        }
        
        return ans;
    }
}