/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//the hard point of this problem is O(h) mem
public class BSTIterator {
    
    Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        
        stk = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            stk.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(!hasNext())
            return -1;
        TreeNode cur = stk.pop();
        int res = cur.val;
        cur = cur.right;
        while(cur != null){
            stk.push(cur);
            cur = cur.left;
        }
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */