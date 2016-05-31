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
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        traverse(root, map);
        
        List<Integer> levelList = new ArrayList<>(map.keySet());
        Collections.sort(levelList);
        for(int level: levelList)
            ans.add(map.get(level));
            
        return ans;
        
    }
    
    public void traverse(TreeNode root,  HashMap<Integer, List<Integer>> map){
        // if(map.containsKey(level))
        //     map.get(level).add(root.val);
        // else{
        //     List<Integer> list = new ArrayList<>();
        //     list.add(root.val);
        //     map.put(level, list);
        // }
        
        // if(root.left != null)
        //     traverse(root.left, level-1, map);
        // if(root.right != null)
        //     traverse(root.right, level+1, map);
            
        //input is [3,9,8,4,0,1,7,null,null,null,2,5]
        //the above code generate 
        //[[4],[9,5],[3,0,1],[2,8],[7]]
        //but correct answer is
        //[[4],[9,5],[3,0,1],[8,2],[7]]
        //so it should be BFS instead of DFS
        
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                pair cur = q.poll();
                if(map.containsKey(cur.level))
                    map.get(cur.level).add(cur.node.val);
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(cur.node.val);
                    map.put(cur.level, list);
                }
                if(cur.node.left != null)
                    q.offer(new pair(cur.node.left, cur.level-1));
                if(cur.node.right != null)
                    q.offer(new pair(cur.node.right, cur.level+1));
            }
        }
        
    }
    
    public class pair{
        TreeNode node;
        int level;
        pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
}