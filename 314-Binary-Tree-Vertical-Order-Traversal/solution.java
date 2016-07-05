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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int left = 0, right = 0;
        TreeNode cur = root.left;
        while(cur != null){
            left++;
            cur = cur.left;
        }
        cur = root.right;
        while(cur != null){
            right++;
            cur = cur.right;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < left+right+1; i++)
            ans.add(new ArrayList<Integer>());
        add(root, 0, map);
        for(int i: map.keySet()){
            ans.set(left+i, map.get(i));
        }
        return ans;
        
    }
    
    public void add(TreeNode root, int level, HashMap<Integer, ArrayList<Integer>> map){
        if(root == null)
            return;
        if(!map.containsKey(level))
            map.put(level, new ArrayList<Integer>());
            
        map.get(level).add(root.val);
        add(root.left, level-1, map);
        add(root.right, level+1, map);
    }
}