/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //have idea but hard problem writing the code
 //can not find of good defination of DP[i]
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] root = new List[n+1];
        //root[i] is all possible trees build with node 0 to i, both inclusive
        root[0] = new ArrayList<>();
        if(n == 0)
            return root[0];
            
        //must add null when n != 0, otherwise the dp can not start
        root[0].add(null);
        
        for(int i = 1; i <=n; i++){
            root[i] = new ArrayList<>();
            for(int j = 1; j <= i; j++){ //use j as root from 1 to i
                for(TreeNode left: root[j-1]){
                    for(TreeNode right: root[i-j]){ 
                    // the right part range is from [j+1 to i], 
                    //  we should let it start from 1 so that we can use the previous results
                    //so offset value shuold be j
                    //and copy it with offset j
                    TreeNode newRoot = new TreeNode(j);
                    newRoot.left = left;
                    newRoot.right = copy(right, j); //each node in right shoud be add j+1 except null
                    root[i].add(newRoot);
                    }
                }
                
            }
        }
        
        return root[n];
    }
    
    public TreeNode copy(TreeNode root, int offset){
        if(root == null)
            return null;
            
        TreeNode newRoot = new TreeNode(root.val + offset);
        newRoot.left = copy(root.left, offset);
        newRoot.right = copy(root.right, offset);
        
        return newRoot;
    }
    
    
}